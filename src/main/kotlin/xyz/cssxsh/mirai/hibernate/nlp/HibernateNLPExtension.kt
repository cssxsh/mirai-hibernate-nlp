package xyz.cssxsh.mirai.hibernate.nlp

import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.unregister
import net.mamoe.mirai.console.plugin.jvm.*

public object HibernateNLPExtension : KotlinPlugin(
    JvmPluginDescription(
        id = "xyz.cssxsh.mirai.plugin.mirai-hibernate-nlp",
        name = "mirai-hibernate-nlp",
        version = "1.0.0",
    ) {
        author("cssxsh")

        dependsOn("xyz.cssxsh.mirai.plugin.mirai-hibernate-plugin", ">= 2.4.0")
    }
) {
    override fun onEnable() {
        HibernateNLPExportCommand.register()
    }

    override fun onDisable() {
        HibernateNLPExportCommand.unregister()
    }
}