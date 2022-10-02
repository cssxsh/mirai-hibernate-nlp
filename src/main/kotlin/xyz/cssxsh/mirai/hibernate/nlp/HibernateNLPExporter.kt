package xyz.cssxsh.mirai.hibernate.nlp

import net.mamoe.mirai.contact.*
import xyz.cssxsh.mirai.hibernate.*
import xyz.cssxsh.mirai.hibernate.entry.*
import java.time.*

public object HibernateNLPExporter {

    @Suppress("INVISIBLE_MEMBER")
    private val factory: org.hibernate.SessionFactory get() = xyz.cssxsh.mirai.hibernate.factory

    public fun original(group: Group, start: LocalDate, end: LocalDate): List<MessageRecord> {
        return MiraiHibernateRecorder.get(
            group = group,
            start = start.atStartOfDay(ZoneId.systemDefault()).toEpochSecond().toInt(),
            end = end.atStartOfDay(ZoneId.systemDefault()).toEpochSecond().toInt()
        )
    }
}