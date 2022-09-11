package xyz.cssxsh.mirai.hibernate.nlp

import net.mamoe.mirai.console.command.*

public object HibernateNLPExportCommand : CompositeCommand(
    owner = HibernateNLPExtension,
    "nlp-export",
    description = "NLP数据导出指令"
) {
    @SubCommand("gpt2")
    public suspend fun ConsoleCommandSender.gpt2() {
        sendMessage("...")
    }

    @SubCommand("temp")
    public suspend fun ConsoleCommandSender.temp() {
        sendMessage("...")
    }
}