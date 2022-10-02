package xyz.cssxsh.mirai.hibernate.nlp

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.contact.*
import net.mamoe.mirai.message.data.*
import java.io.File
import java.time.*

public object HibernateNLPExportCommand : CompositeCommand(
    owner = HibernateNLPExtension,
    "nlp-export",
    description = "NLP数据导出指令"
) {
    @SubCommand
    public suspend fun CommandSender.original(group: Group, start: LocalDate, end: LocalDate = LocalDate.now()) {
        val message = try {
            val records = HibernateNLPExporter.original(group = group, start = start, end = end)
            val file = File("./${group.id}_${start}_${end}.json")
            file.writeText(Json.encodeToString(records))

            "原始数据已导出到 ${file.absolutePath} "
        } catch (cause: Exception) {
            HibernateNLPExtension.logger.warning(cause)
            "原始数据已导出失败"
        }

        sendMessage(message = message)
    }

    @SubCommand
    public suspend fun CommandSender.gpt2(group: Group, start: LocalDate, end: LocalDate = LocalDate.now()) {
        val message = try {
            val records = HibernateNLPExporter.original(group = group, start = start, end = end)
            val file = File("./${group.id}_${start}_${end}.json")
            val contents = ArrayList<String>(records.size)
            for (record in records) {
                val chain = record.toMessageChain()
                val plain = chain.singleOrNull() as? PlainText ?: continue
                contents.add(plain.content)
            }
            file.writeText(Json.encodeToString(contents))

            "GPT2数据已导出到 ${file.absolutePath} "
        } catch (cause: Exception) {
            HibernateNLPExtension.logger.warning(cause)
            "GPT2数据已导出失败"
        }

        sendMessage(message = message)
    }
}