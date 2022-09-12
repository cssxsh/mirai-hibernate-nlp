package xyz.cssxsh.mirai.hibernate.nlp

import net.mamoe.mirai.contact.*
import xyz.cssxsh.mirai.hibernate.*
import xyz.cssxsh.mirai.hibernate.entry.*
import java.time.*
import java.time.temporal.Temporal

public object HibernateNLPExporter {

    @Suppress("INVISIBLE_MEMBER")
    private val factory: org.hibernate.SessionFactory get() = xyz.cssxsh.mirai.hibernate.factory

    public fun original(group: Group, start: Temporal, end: Temporal): List<MessageRecord> {
        return MiraiHibernateRecorder[group, Instant.from(start).epochSecond.toInt(), Instant.from(end).epochSecond.toInt()]
    }
}