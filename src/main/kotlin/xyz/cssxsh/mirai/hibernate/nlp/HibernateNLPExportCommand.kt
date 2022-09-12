package xyz.cssxsh.mirai.hibernate.nlp

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.contact.*
import java.io.File
import java.time.*

public object HibernateNLPExportCommand : CompositeCommand(
    owner = HibernateNLPExtension,
    "nlp-export",
    description = "NLP数据导出指令"
) {
    @SubCommand
    public suspend fun ConsoleCommandSender.original(group: Group, date: LocalDate) {
        val message = try {
            val start = date.atStartOfDay(ZoneId.systemDefault())
            val records = HibernateNLPExporter.original(group = group, start = start, end = start.plusDays(1))
            val file = File("./${group.id}_${date}.json")
            file.writeText(Json.encodeToString(records))

            "数据已导出到 ${file.absolutePath} "
        } catch (cause: Exception) {
            HibernateNLPExtension.logger.warning(cause)
            "数据已导出失败"
        }

        sendMessage(message = message)
    }
}