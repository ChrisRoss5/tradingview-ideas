![App preview](/preview-images/1.png)

# Setup

- Download [JDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html).
- Run SQL Server database initialization: [init.sql](sql/init.sql)
- Adjust database properties: [db.properties](Dao/src/main/resources/config/db.properties)
- Run TradingView Ideas and log in as 'admin' or 'user'. The passwords are the same as the usernames.

## RSS Feed

- Instructions: [tradingview.com/widget](https://www.tradingview.com/widget)
- Source: [tradingview.com/feed](https://www.tradingview.com/feed)

If the source is no longer working, update the `RSS_URL` in [IdeaParser.java](TradingViewIdeas\src\main\java\hr\algebra\parser\rss\IdeaParser.java) to use the files in [RSS_backup](/RSS_backup/) and adjust the query string params in the parser function.

---
For more info, see task specifications:

- [specs-en.pdf](specs-en.pdf)
- [specs-hr.pdf](specs-hr.pdf)
