package com.example.homepage.toplist.bean

/**
 * Tab的信息
 */
interface TabData {
    val content: String
}

data class SimpleTabData(
    override val content: String
): TabData



/*
*  找了一圈没找到tag和对应榜单的映射，因此固定写在这里
*  首页 -> [飙升、新歌、热歌、原创]
*  精选 -> [黑胶VIP爱听榜、网络热歌榜]
*  曲风 -> [云音乐电音、云音乐ACG、云音乐说唱、
*          云音乐摇滚、云音乐民谣、云音乐国电
*          云音乐古典、云音乐古风、中文DJ]
*  全球 -> [美国Billboard榜、UK排行榜周榜、日本Oricon榜、
*          法国 NRJ Vos Hits 周榜、俄罗斯top hit流行音乐榜、云音乐欧美新歌榜
*          云音乐欧美热歌榜、云音乐日语榜、云音乐韩语榜
*          俄语榜、越南语榜]
*  特色 -> [听歌识曲榜、潜力爆款榜、中国新乡村音乐排行榜
*         KTV唛榜、Beatport全球电子舞曲榜]
*
* */
internal val topListIdMap: Map<TopListTab, List<Long>> = mapOf(
    TopListTab.Official to listOf(
        19723756, 3779629, 3778678, 2884035
    ),
    TopListTab.Handpick to listOf(
        5453912201, 6723173524
    ),
    TopListTab.Genre to listOf(
        1978921795, 71385702, 991319590,
        5059633707, 5059661515, 10520166,
        71384707, 5059642708, 6886768100
    ),
    TopListTab.Global to listOf(
        60198, 180106, 60131,
        27135204, 6939992364, 2809577409,
        2809513713, 5059644681, 745956260,
        6732051320, 6732014811
    ),
    TopListTab.Characteristic to listOf(
        6688069460, 5338990334, 3112516681,
        21845217, 3812895,
    )
)

