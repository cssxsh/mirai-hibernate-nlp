package xyz.cssxsh.mirai.hibernate.nlp

import net.mamoe.mirai.contact.Group
import xyz.cssxsh.hibernate.withCriteria
import xyz.cssxsh.mirai.hibernate.MiraiHibernateRecorder

public object HibernateNLPExporter {

    @Suppress("INVISIBLE_MEMBER")
    private val factory: org.hibernate.SessionFactory get() = xyz.cssxsh.mirai.hibernate.factory

    public fun gpt2(group: Group) {
        MiraiHibernateRecorder[group].use { stream ->
            stream
        }
    }
}