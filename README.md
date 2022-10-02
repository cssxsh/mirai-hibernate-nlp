# [Mirai Hibernate NLP](https://github.com/cssxsh/mirai-hibernate-nlp)

> Mirai Hibernate Plugin 的 NLP 扩展，用于导出 NLP 所用聊天数据

相关项目:  
[Mirai Hibernate Plugin](https://github.com/cssxsh/mirai-hibernate-plugin) 前置插件，用于 Hibernate ORM 框架的初始化

## Command

### nlp-export

* `/nlp-export original <group> <start> <end>` 导出 原始数据 
  举例: `/nlp-export original 123456 2022-09-01 2022-10-01`

* `/nlp-export gpt2 <group> <start> <end>` 导出 原始数据
  举例: `/nlp-export gpt2 123456 2022-09-01 2022-10-01`

## 安装

### 手动安装

1. 运行 [Mirai Console](https://github.com/mamoe/mirai-console) 生成 `plugins` 文件夹
2. 从 [Releases](https://github.com/cssxsh/mirai-hibernate-nlp/releases) 下载 `jar` 并将其放入 `plugins` 文件夹中