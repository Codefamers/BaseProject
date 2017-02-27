package com.qhn.bhne.baseproject.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */

public class RecommendContent  {

    /**
     * status : 1
     * errcode : 0
     * data : {"timestamp":1488090137,"info":{"recommend":[{"imgurl":"","title":"歌手2017 合辑","id":16095,"type":1,"online":1488038400,"extra":{"play_count":13230392,"specialname":"歌手2017 合辑","publishtime":"2017-02-19","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！","suid":509004464,"specialid":121575,"collectcount":30042,"user_name":"战战战","slid":27}},{"imgurl":"","title":"任何年龄段都会爱上的经典好歌","id":16097,"type":1,"online":1488038400,"extra":{"play_count":3523778,"specialname":"任何年龄段都会爱上的经典好歌","publishtime":"2017-02-23","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170223/20170223163949547794.jpg","intro":"管你什么80后90后00后，都会爱上这时光沉淀的美好情愫\u2026\u2026","suid":509005747,"specialid":122292,"collectcount":764,"user_name":"小胖","slid":29}},{"imgurl":"","title":"听粤语，品味歌词的细腻","id":16099,"type":1,"online":1488038400,"extra":{"play_count":323367,"specialname":"听粤语，品味歌词的细腻","publishtime":"2017-02-23","singername":"","verified":0,"songcount":49,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170223/20170223152747103319.jpg","intro":"听粤语，品味歌词的细腻。","suid":509005749,"specialid":122290,"collectcount":118,"user_name":"片刻诗意","slid":29}},{"imgurl":"","title":"一周超好听新歌","id":16101,"type":1,"online":1488038400,"extra":{"play_count":114433,"specialname":"一周超好听新歌(2017-02-24)","publishtime":"2017-02-24","singername":"","verified":0,"songcount":46,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170224/20170224212543651832.jpg","intro":"酷狗独家的歌手李佑晨发新歌啦！一首《庙会街上》，让我们对她有了全新的认识。而本周很多大牌的合作也引人关注，点进歌单，期待你与最美好的声音相遇！","suid":509005720,"specialid":122319,"collectcount":52,"user_name":"张玉宝","slid":28}},{"imgurl":"","title":"80后的集体回忆","id":16103,"type":1,"online":1488038400,"extra":{"play_count":64663195,"specialname":"80后的集体回忆","publishtime":"2016-11-29","singername":"","verified":0,"songcount":90,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150826/20150826103256242218.jpg","intro":"那些伴随我们成长而逐渐消散、珍藏在记忆里的美好怀念，不会随同岁月流逝。80后，十年的时间，产生多少经典，留下多少美好，我们都能从歌里听到。","suid":373452663,"specialid":25362,"collectcount":77033,"user_name":"彼岸花","slid":97}},{"imgurl":"","title":"小曲调，小清新","id":16105,"type":1,"online":1488038400,"extra":{"play_count":506838,"specialname":"小曲调，小清新","publishtime":"2017-02-21","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170221/20170221173435412732.jpg","intro":"曲风大都清爽自然、温暖感动、可爱唯美。","suid":509005801,"specialid":122238,"collectcount":642,"user_name":"可可玲儿","slid":29}},{"imgurl":"","title":"人生只若初见","id":16107,"type":1,"online":1488038400,"extra":{"play_count":564673,"specialname":"人生只若初见","publishtime":"2017-02-15","singername":"","verified":0,"songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215161028785597.jpg","intro":"终是谁使弦断，花落肩头，恍惚迷离，终只落下一段无果的缘，落得一句：\u201c人生只若初见。\u201d","suid":509005898,"specialid":122141,"collectcount":1256,"user_name":"冰雪凌","slid":27}},{"imgurl":"","title":"最动听的英文励志歌","id":16109,"type":1,"online":1488038400,"extra":{"play_count":8803878,"specialname":"最动听的英文励志歌","publishtime":"2016-11-28","singername":"","verified":0,"songcount":37,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150807/20150807194200801227.jpg","intro":"如果受到了伤害、遇到了挫折，不要害怕，还有音乐永远陪着你！","suid":656896302,"specialid":25917,"collectcount":24097,"user_name":"柠檬幽阁","slid":6}},{"imgurl":"","title":"用歌词说一个故事","id":16111,"type":1,"online":1488038400,"extra":{"play_count":2154193,"specialname":"用歌词说一个故事","publishtime":"2016-01-16","singername":"","verified":0,"songcount":53,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160116/20160116151918421508.jpg","intro":"当日子成为旧照片，当旧照片成为回忆，我们成了背对背行走的路人，沿着不同的方向固执地一步步远离。","suid":509001591,"specialid":57461,"collectcount":5102,"user_name":"夏至＊未至","slid":48}},{"imgurl":"","title":"唱一首远方的民谣","id":16113,"type":1,"online":1488038400,"extra":{"play_count":1530951,"specialname":"唱一首远方的民谣","publishtime":"2016-12-09","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161209/20161209151914967486.jpg","intro":"回忆总是那么的猝不及防，走过的街道曾有你的身影，路过的咖啡店有属于你独特的味道，翻开旧照才发现你已经离我远去。","suid":509005075,"specialid":120964,"collectcount":2499,"user_name":"柳云腾","slid":29}},{"imgurl":"","title":"你不再回忆，我忘了忘记","id":16115,"type":1,"online":1488038400,"extra":{"play_count":5343085,"specialname":"你不再回忆，我忘了忘记","publishtime":"2016-07-27","singername":"","verified":0,"songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160727/20160727151816156621.jpg","intro":"最美的不是下雨天而是曾与你躲过雨的屋檐\u2026","suid":509004933,"specialid":117167,"collectcount":1372,"user_name":"叮咚","slid":26}},{"imgurl":"","title":"失恋时才有体会的伤感音符","id":16117,"type":1,"online":1488038400,"extra":{"play_count":3135337,"specialname":"失恋时才有体会的伤感音符","publishtime":"2016-03-23","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150526/20150526162801448346.jpg","intro":"我们的爱情竟也走到了终点，可是你的影子却一直在我心里没离开过，悲伤的情绪像是毒瘤，蔓延入我的全身。在失恋这场破伤风里，难免会有悲伤和难过，不要隐藏不要抑制，听听这些失恋专属歌，以毒攻毒，或许会好很多。","suid":373452606,"specialid":25155,"collectcount":8479,"user_name":"通往地狱的火车","slid":99}},{"imgurl":"","title":"让你心情愉悦的清新小调","id":16119,"type":1,"online":1488038400,"extra":{"play_count":560129,"specialname":"让你心情愉悦的清新小调","publishtime":"2016-10-17","singername":"","verified":0,"songcount":32,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161017/20161017163928169877.jpg","intro":"让你心情愉悦的清新小调","suid":509004847,"specialid":119253,"collectcount":1562,"user_name":"蝶舞清风","slid":28}},{"imgurl":"","title":"藏在我手机里的英文好歌","id":16121,"type":1,"online":1488038400,"extra":{"play_count":54819928,"specialname":"藏在我手机里的英文好歌","publishtime":"2016-05-10","singername":"","verified":0,"songcount":87,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160511/20160511171756788560.jpg","intro":"英文，一直是我最喜欢的语言。它是灵魂深处的悸动，清楚，分明。它是远别于喧嚣的沉静，流淌在时间里，有些经典，有些传唱。它和电影，是我最喜欢的叙述方式，它不像是一种途径，更像是一扇窗，让你看得真切。在它的语言里，我遇见了用真实的情感来叙述，遇见来自生活，抑或来自内心的吟唱。","suid":509006090,"specialid":114010,"collectcount":52143,"user_name":"小李子","slid":24}},{"imgurl":"","title":"听到就会哼的熟悉旋律","id":16123,"type":1,"online":1488038400,"extra":{"play_count":2653335,"specialname":"听到就会哼的熟悉旋律","publishtime":"2016-01-30","singername":"","verified":0,"songcount":253,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160130/20160130191340608384.jpg","intro":"有些歌，第一次听就似曾相识；有些歌，已经多年没听；有些歌，早已听过却不知道原来是你\u2026\u2026","suid":509001388,"specialid":57897,"collectcount":6880,"user_name":"烟雨霏霏","slid":48}},{"imgurl":"","title":"我以为有一天我会忘记你","id":16125,"type":1,"online":1488038400,"extra":{"play_count":380644,"specialname":"我以为有一天我会忘记你","publishtime":"2015-05-14","singername":"","verified":0,"songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20151013/20151013142952758753.jpg","intro":"人都有一份孤独，再繁华的热闹，有一颗冷心观红尘，但唯独他，一眼洞穿你的清寂你的凉，一眼明白这世间所有的繁华不过是你和他身边的过眼云烟，他会在众人之间一眼看到你，然后读懂你，明白你，不似爱情，胜似爱情。","suid":509001400,"specialid":29839,"collectcount":365,"user_name":"筎礠愛妳","slid":7}},{"imgurl":"","title":"伴我成长的校园歌曲","id":16127,"type":1,"online":1488038400,"extra":{"play_count":21173787,"specialname":"伴我成长的校园歌曲","publishtime":"2016-05-30","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160530/20160530172903312132.jpg","intro":"又是一年毕业季，还好，你也在这错漏百出的青春里；还好，这些校园民谣都曾经陪着我们度过青春。还好。我的青春里有你！毕业季，酷狗与你一起用音乐纪念青春。","suid":509004681,"specialid":115419,"collectcount":10272,"user_name":"伤痕","slid":26}},{"imgurl":"","title":"童年儿歌 童声飞扬","id":16129,"type":1,"online":1488038400,"extra":{"play_count":8519431,"specialname":"童年儿歌 童声飞扬","publishtime":"2016-11-29","singername":"","verified":0,"songcount":60,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150201/20150201192759915542.jpg","intro":"妈妈们看过来，这张歌单专为宝宝们准备，让它成为宝宝们的音乐启蒙歌单，让他们生活在梦幻的人间，在音乐中茁壮成长！","suid":373452674,"specialid":24208,"collectcount":15547,"user_name":"罗曼司","slid":80}},{"imgurl":"","title":"给生活一点温暖","id":16131,"type":1,"online":1488038400,"extra":{"play_count":2757842,"specialname":"给生活一点温暖","publishtime":"2016-08-29","singername":"","verified":0,"songcount":74,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160829/20160829151719538012.jpg","intro":"我或许败北，或许迷失自己，或许哪里也抵达不了，或许我已失去一切，任凭怎么挣扎也只能徒呼奈何，或许我只是徒然掬一把废墟灰烬，唯我一人蒙在鼓里，或许这里没有任何人把赌注下在我身上。无所谓。有一点是明确的：至少我有值得等待有值得寻求的东西。","suid":509006018,"specialid":118082,"collectcount":2451,"user_name":"妲己笑","slid":25}},{"imgurl":"","title":"忘了我忘不了你","id":16133,"type":1,"online":1488038400,"extra":{"play_count":314333,"specialname":"忘了我忘不了你","publishtime":"2017-01-31","singername":"","verified":0,"songcount":25,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170131/20170131222425201402.jpg","intro":"忘了我忘不了你。网络伤感歌曲为你诚意推荐。","suid":509004196,"specialid":121843,"collectcount":183,"user_name":"赤砂之蠍","slid":28}},{"imgurl":"","title":"不闹不躁的小资韩语歌","id":16135,"type":1,"online":1488038400,"extra":{"play_count":2834444,"specialname":"不闹不躁的小资韩语歌","publishtime":"2016-07-06","singername":"","verified":0,"songcount":134,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160706/20160706153955751121.jpg","intro":"自家小店用音乐，刚刚好。","suid":509005580,"specialid":116520,"collectcount":2085,"user_name":"独行","slid":26}},{"imgurl":"","title":"粤语金曲：时光流逝，愈发香醇","id":16137,"type":1,"online":1488038400,"extra":{"play_count":5186106,"specialname":"粤语金曲：时光流逝，愈发香醇","publishtime":"2017-02-06","singername":"","verified":0,"songcount":27,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206163935939826.jpg","intro":"谁说时间会抹去一切？至少这些存世的经典好歌并没有半点失色，再度回首，依旧在心中翻起一片波澜，也许你会说她老，但她却代表了一个时代，一段情怀。","suid":509006064,"specialid":121975,"collectcount":2299,"user_name":"笨笨的情","slid":29}},{"imgurl":"","title":"这些歌，你真的舍得删除吗","id":16139,"type":1,"online":1488038400,"extra":{"play_count":1208553,"specialname":"这些歌，你真的舍得删除吗","publishtime":"2017-02-06","singername":"","verified":0,"songcount":30,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206115506639690.jpg","intro":"这些百听不厌，万里挑一的歌曲，总是舍不得删除的经典歌曲，一次性呈现给大家！","suid":509006071,"specialid":121968,"collectcount":1845,"user_name":"毒龙","slid":29}},{"imgurl":"","title":"中文DJ热歌 至嗨舞曲","id":16141,"type":1,"online":1488038400,"extra":{"play_count":7906857,"specialname":"中文DJ热歌 至嗨舞曲","publishtime":"2017-01-12","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170109/20170109180126610978.jpg","intro":"网友最爱的中文DJ热歌，超嗨舞曲夜店热播！","suid":509004491,"specialid":121548,"collectcount":10651,"user_name":"放弃","slid":27}},{"imgurl":"","title":"夜店老司机 DJ热歌带你飞","id":16143,"type":1,"online":1488038400,"extra":{"play_count":1511540,"specialname":"夜店老司机 DJ热歌带你飞","publishtime":"2017-02-21","singername":"","verified":0,"songcount":45,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170221/20170221143708437981.jpg","intro":"夜店老司机来了！给你最嗨最火的夜店嗨歌！","suid":509005818,"specialid":122221,"collectcount":2090,"user_name":"飘然流水","slid":28}},{"imgurl":"","title":"挚爱华语深情女声","id":16145,"type":1,"online":1488038400,"extra":{"play_count":1989783,"specialname":"挚爱华语深情女声","publishtime":"2017-02-06","singername":"","verified":0,"songcount":37,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206175116231795.jpg","intro":"\u201c那时，被触心的旋律吸引，但并不知道是你所唱；此刻，熟悉的旋律响起，才知道那时的相遇，是件多么幸运、多么美好的事情。\u201d写在开头，写给自己，写给那些美好的旧时光。","suid":509006053,"specialid":121986,"collectcount":2278,"user_name":"李彬","slid":29}},{"imgurl":"","title":"最经典狂热舞曲","id":16147,"type":1,"online":1488038400,"extra":{"play_count":37067268,"specialname":"最经典狂热舞曲","publishtime":"2013-10-08","singername":"","verified":0,"songcount":125,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160302/20160302133124542543.jpg","intro":"最狂热经典舞曲！","suid":509001143,"specialid":58838,"collectcount":24592,"user_name":"无语_sE2B1","slid":48}},{"imgurl":"","title":"唯有歌与酒，可以消寂寞","id":16149,"type":1,"online":1488038400,"extra":{"play_count":399698,"specialname":"唯有歌与酒，可以消寂寞","publishtime":"2015-09-01","singername":"","verified":0,"songcount":36,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150901/20150901174620849298.jpg","intro":"寂寞、孤独、痛苦\u2026\u2026治愈这些的良药，只有音乐和烟酒。","suid":509001564,"specialid":26163,"collectcount":2644,"user_name":"颜祖/:heart","slid":2}},{"imgurl":"","title":"怀念经典 致敬经典","id":16151,"type":1,"online":1488038400,"extra":{"play_count":12052107,"specialname":"怀念经典 致敬经典","publishtime":"2017-02-15","singername":"","verified":0,"songcount":44,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215155929694880.jpg","intro":"那些耳熟能详的经典老歌，值得单曲循环。","suid":509005899,"specialid":122140,"collectcount":5651,"user_name":"江南","slid":29}},{"imgurl":"","title":"【耳朵怀孕】热评过万电音","id":16153,"type":1,"online":1488038400,"extra":{"play_count":29468585,"specialname":"【耳朵怀孕】热评过万电音","publishtime":"2016-07-15","singername":"","verified":0,"songcount":53,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160716/20160716105415269821.jpg","intro":"每一首都是精选，过万人评论。此歌单我会持续更新！","suid":509005248,"specialid":116852,"collectcount":74243,"user_name":"混世枭雄","slid":26}}],"operation":[],"song":[{"filename":"张杰 - 哥哥","songname":"哥哥","sqhash":"547BEEB883FB32F3DC7DF14072D42BC4","hash":"67E7D056772F4FAE0747843D0A72375A","mvhash":"","privilege":0,"filesize":5736838,"addtime":"2017-02-25 18:34:10","bitrate":128,"320filesize":14343360,"Accompany":1,"isfirst":1,"singername":"张杰","sqfilesize":36095650,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170111/20170111104600449.jpg","duration":359,"m4afilesize":0,"extname":"mp3","320hash":"96A181792E2E96F1BDC7A03F9415CB27","sqprivilege":0,"intro":"","feetype":0},{"filename":"刘惜君 - 线","songname":"线","sqhash":"9CC080C7A31C636DD257021E90E8D242","hash":"97AFB411D2B6657B89B7F5563A748129","mvhash":"E4F93AD043ABD6E871258EE67F6064E3","privilege":0,"filesize":4406169,"addtime":"2017-02-21 12:09:03","bitrate":128,"320filesize":11015398,"Accompany":0,"isfirst":1,"singername":"刘惜君","sqfilesize":29236491,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20160429/20160429120406872.jpg","duration":275,"m4afilesize":0,"extname":"mp3","320hash":"18119BD8B4DFB547F1068728A6367918","sqprivilege":0,"intro":"","feetype":0},{"filename":"孙露 - 痛快人生","songname":"痛快人生","sqhash":"30C4AFD84A99E2EFEAFAA77B5BC2FA48","hash":"041332BF26D36D8CB2A7DA84CD8BFC83","mvhash":"","privilege":0,"filesize":4549399,"addtime":"2017-02-23 10:32:18","bitrate":127,"320filesize":11374759,"Accompany":1,"isfirst":1,"singername":"孙露","sqfilesize":28711725,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170221/20170221154248275887.jpg","duration":284,"m4afilesize":0,"extname":"mp3","320hash":"E53F82C5DA606863DD73298210B3D248","sqprivilege":0,"intro":"","feetype":0},{"filename":"戴佩妮 - 贼","songname":"贼","sqhash":"F4485C9009278724EC4593EB2425CE60","hash":"E51AD48CCE1C3607E3ADED93920858D7","mvhash":"9577AEDF6552B5CBF21CE106D531C959","privilege":0,"filesize":3511461,"addtime":"2016-08-04 17:36:46","bitrate":128,"320filesize":8778231,"Accompany":1,"isfirst":0,"singername":"戴佩妮","sqfilesize":25440255,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20160830/20160830172353700.jpg","duration":219,"m4afilesize":0,"extname":"mp3","320hash":"75D13B872FCF1A504493B91BAC8FEB63","sqprivilege":0,"intro":"","feetype":0},{"filename":"唐古 - 用尽一生爱你","songname":"用尽一生爱你","sqhash":"264C94DAF54084D63F2427A337A4AD9F","hash":"00C2291F8C3B70E3E5EDDBAA8658F2A1","mvhash":"A16A3C9D1DA25AC39B6B479E4EFAC61E","privilege":0,"filesize":4036564,"addtime":"2016-08-08 15:39:14","bitrate":128,"320filesize":10092669,"Accompany":1,"isfirst":1,"singername":"唐古","sqfilesize":30210139,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20161008/20161008114017219.jpg","duration":252,"m4afilesize":0,"extname":"mp3","320hash":"E4758AD2F05ECE98213BAA4B78D086BB","sqprivilege":0,"intro":"","feetype":0}],"vlist":[{"des":"第89届奥斯卡将于2月27日隆重举行！《爱乐之城》《雄狮》《星际迷航3》等众多电影获提名入围，精彩的故事再配上触动灵魂的配乐，神切入的旋律与步步推进的剧情交错相连，让人沉醉，现在就让我们一起欣赏本届奥斯卡提名电影的精彩配乐。","public_time":"2017/02/24","title":"第89届奥斯卡提名电影配乐合集","cate":"影视原声","vid":69567,"mobile_banner":"http://imge.kugou.com/commendpic/20170224/20170224184420299424.jpg","hot_num":1034},{"des":"情人节要来了！虐狗日要到了！单身无罪好么\u2026\u2026为了营造浓厚节日气氛，让大家都能感受到满满的爱，小编特意收集了一群甜到溢出屏幕的明星情侣MV，发现了一个大秘密，原来爱就是，他的眼里只有你！","public_time":"2017/02/14","title":"亲爱哒，我的眼里只有你！","cate":"特别策划","vid":68097,"mobile_banner":"http://imge.kugou.com/commendpic/20170213/20170213141522344064.jpg","hot_num":41373},{"des":"第59届格莱美奖火爆来袭！阿黛尔成为大赢家，五提五中！碧昂斯身怀双胞胎依然献上高难度表演！摇滚Ga大玩\u201c跳水\u201d嗨翻全场！还有众星联合舞台，致敬故人！超精彩的现场表演，不容错过！","public_time":"2017/02/13","title":"第59届格莱美奖精彩回顾","cate":"特别策划","vid":68091,"mobile_banner":"http://imge.kugou.com/commendpic/20170213/20170213123923845336.jpg","hot_num":31521},{"des":"2016年有哪些爆红的影视作品？！年初的《太阳的后裔》让全国男男女女天天喊宋老公。小鲜肉出演的各大IP影视作品让人应接不暇！爆米花电影当然不能少了欧美大片！它们这么红！你们一定看过！","public_time":"2017/02/05","title":"年终MV盘点：影视篇","cate":"影视原声","vid":65773,"mobile_banner":"http://imge.kugou.com/commendpic/20170205/20170205145200877434.jpg","hot_num":51228}],"album":[{"albumname":"歌手2017 第六期","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","singerid":637338,"publishtime":"2017-02-25","singername":"歌手2017","albumid":1974548,"privilege":0},{"albumname":"徘徊","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170224/20170224174736660720.jpg","intro":"十二月，遇见王青\n\n在大众的眼中，王青是新生代艺人迅速崛起的象征，\n耀眼的光环和失控的尖叫，\n伴随着些许的争议和质疑一并而来\n外界赋予他的一切标签，反而让王青沉了下来，\n怀着淡然而绝决的心态，安静做着自己的计划，\n这目标并不宏伟，也不狂野，\n但他希望保留自己的风格，\n借助恰当的形式，去说一些想说的话，\n传达一种要表达的态度。\n\n作为新人，他永远保持着旺盛的求知欲，\n他热爱表演，努力将自己的灵魂浇灌至自己的角色；\n他也热爱音乐，想将他衷爱的旋律，用他的方式演绎；\n终于，现在，可以大声的说出自己的音乐态度。\n关于音乐，他有很多奇妙的想法。\n那些古典弦乐和潮流电音，\n那些循环的节奏和叠加的层次，\n他总能从中抓到一些不一样的小惊喜，\n带着些许的期待，\n悄悄地种在自己的音乐里。\n\n为了给自己一个满意的作品，\n王青坦言，每一个作品的完成对自己而言都是一次蜕变，\n诞生出一个新的不同的自己。\n当专辑最后一首歌录完，王青走出录音棚，\n他说，Not Bad，嗯，这感觉不错\n\n所以你能在这张《十二月》中听到一个不同风格、多元形态的王青，\n与你之前见到的都不一样\n他不试图复制自己，也不效仿他人，\n他只是希望把自己融入声音，唱自己想唱的歌，\n懂他的人，会懂。\n反复的打磨，出自匠心，匠意，\n呈现出来的终将是份诚意满满的心意，\n是DEMO在此刻的终结，\n又预示着另一种全新模式的开启。\n\n如果名字只能是代号和标签，\n那么他就要把自己拆解，\n细致淬炼，重塑最新的自己。\n每一首歌都代表不同的他，\n五个不同的故事，\n五种不同的阶段，\n不断进化，不断更新，\n多面且真实，\n十二月，让我们遇见王青","singerid":85715,"publishtime":"2017-02-25","singername":"王青","albumid":1974311,"privilege":0},{"albumname":"向天再要500话","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170224/20170224093333840556.jpg","intro":"腾讯动漫催更神曲 薛之谦魔性出演\n彩虹室内合唱团献声演唱\n追不完的海量日更，只在腾讯动漫APP","singerid":287581,"publishtime":"2017-02-24","singername":"上海彩虹室内合唱团","albumid":1973958,"privilege":0},{"albumname":"Where Do We Go(Soul Remix)","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170222/20170222111450744937.jpg","intro":"Lara梁心颐这次推出的单曲「Where Do We Go: SOUL REMIX」又让她踏进了一个全新领域。作为Lara的初次Soul/R&B风格体验，歌曲的有机live band氛围、充满爆发力的饶舌演出、和Lara表现上的突破，保证会让所有歌迷耳目一新。「Where Do We Go: SOUL REMIX」邀请了RoboKatz合作，制作人斐立普 Felipe Z.表示当初听到了「Where Do We Go」原版特别欣赏这首歌的旋律和气氛呈现，但因为喜欢用新角度诠释一首歌，他对「Where Do We Go」的欣赏，反而激发了动力去尝试台湾音乐市场少数能听到的风格。\n\n说到突破，「Where Do We Go: SOUL REMIX」也邀请了Robokatz Music旗下的饶舌歌手吕士轩（a.k.a.TroutFresh）来参与一段rap。来自于曾受过Amei张惠妹好评的独立乐团 SmashRegz/违法的他，独特的嗓音和rap flow让Remix多了层次。制作人Felipe 说TroutFresh的部分不只让歌更有张力跟生命力，也与Lara的甜嗓搭配的刚刚好 ，形成一钢一柔的绝妙组合。\n\nLara透露在制作「Where Do We Go」原版的过程中已经想要尝试加rap了，但因为想保留最纯粹的味道所以计划就先搁置了。身为有原版的词曲创作人之一，Lara第一次听到Robokatz制作的版本就马上情不自禁地露出微笑，表示新的编曲给了「Where Do We Go」一种万万没想到的新生命。「因为这首歌原曲是与Jason的编曲一起诞生的，所以在我脑海中它一直就是那个氛围。Robokatz与Troutfresh把原本冷清神秘的氛围加了温暖甚至活泼的成份，意外又惊喜。」\n\n因父亲喜好的关系，Lara从小耳濡目染的是Bob Dylan、Beatles这些音乐人，可以说摇滚和民谣才是她音乐的原点。后来为了「Where Do We Go: SOUL REMIX」她被Felipe逼出了很少尝试的R&B唱腔，甚至阔别十年再次跟饶舌歌手合作（上次是07年与MC Hotdog），再次地打破了从前被大公司保护着的偶像包袱，让大家知道她是懂得将嗓音变化自如的歌手，而且还能拓展到各种类型的音乐上，不会单单停滞在流行的领域当中。\n\n尤其在录完音后，她更加强对自己创作能力的信心了，因为有生命力的歌曲，不管用任何形式的类型重新编排，都会展现出它的特色。希望藉由「Where Do We Go: SOUL REMIX」让再临人间的迷途精灵Lara梁心颐，披露她蜕变后的全新姿态在你们的眼前。","singerid":83769,"publishtime":"2017-02-22","singername":"梁心颐","albumid":1973050,"privilege":0},{"albumname":"Venture","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170221/20170221123906430252.jpg","intro":"时间是为了定位现在而创造的伪概念，人类像乘坐着宇宙中最快的交通工具，以不可思议的速度打败数字，进行迭代。而让我们进化的，是打破原本平稳无聊状态的欲望。\n千篇一律的风格、含糊不清的态度、语焉不详的说辞\u2026\u2026鹿晗站在这些的反面，玩一个粉碎无趣的游戏。守着山洞里的财宝固然安全，却也让骑士变成恶龙。是冒险家穿过未知海域发现新大陆，才让人看见世界的轮廓。鹿晗在每一次的音乐大航海里，燃烧着从不止步的冒险精神，让他区分于其他单薄的人设，成为混沌中令人一眼定睛的鲜活角色。\n《Venture》一如既往承担着开拓的责任，鹿晗经历种种而后成长，以锐利的音乐之刃切割迷雾，试图唱出更多人与人之间关系的结构，更深入寻找音乐的可能性。\n《如果 What if I said》精致的Contemporary R&B，时髦的情歌句型\n延续《某时某刻》的幕后阵容，由Santell和Picard Brothers（Maxme Picard与Clement Picard）为《如果 What if I said》担纲制作，以入耳即化的温柔旋律突出鹿晗的声音色彩，辅以更为犀利的电子音效，点破恋爱行至分崩离析时，「想触碰却收回手」的姿态。对你的舍不得，是在自己的对话框里任凭心情风起云涌，也克制地按下delete。这是我和你的关系里，我最后的秘密。\n相比于在恋爱的语境里充满过剩的情绪，鹿晗更善于用更为轻盈的叙事来展现当下年轻人的行事风格。学会接受爱的到来与消失，是成长的必经之路。《如果 What if I said》以精细的编曲和演唱方式，展现出梦幻而易碎的年轻人的恋爱形态和成长后的处理方式。\n《敢 Roleplay》态度重磅出击，有话直说的trap招式\n是不是经常会遇见不懂分寸、没有界限的人来打扰你的节奏？或者听见那些躲在暗处的偷窥癖咀嚼着你生活的细枝末，大放厥词？是不敢直视小丑的眼睛，对杂音习以为常，还是用真实的态度为自己想要的世界投票？\n全新歌曲《敢 Roleplay》用最时髦的trap曲风，通过犀利的rap，松弛而充满趣味的编曲，淋漓尽致地展现了鹿晗的耿直率性，哪怕在亿万人注视的镁光灯聚焦下，鹿晗也选择\u201c有话直说\u201d，用音乐坦诚表达，在现象里挖掘更多深意，为所有感同身受而唱。","singerid":173452,"publishtime":"2017-02-21","singername":"鹿晗","albumid":1972050,"privilege":10},{"albumname":"音乐大师课 第二季 第八期","imgurl":"http://imge.kugou.com/stdmusic/{size}/20160402/20160402152625445247.jpg","intro":"《音乐大师课》由世熙传媒联合北京卫视打造，由顶级音乐人教天赋少年唱经典歌曲，一档真正的少儿音乐成长节目。2016年\u201c第二学年\u201d正式开启！","singerid":187388,"publishtime":"2016-04-02","singername":"音乐大师课","albumid":1399575,"privilege":0}],"custom_special":[{"title":"主题歌单 · 那些你反复哼起的华语歌曲","special":[{"play_count":5156028,"specialname":"粤语好歌 值得反复聆听","publishtime":"2016-11-30","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161130/20161130175801678009.jpg","intro":"始终觉得删了可惜的歌哦！","suid":509005376,"specialid":120724,"collectcount":5684,"user_name":"天使的守护","slid":29},{"play_count":85223,"specialname":"那些引起人共鸣的循环单曲","publishtime":"2016-12-21","singername":"","verified":0,"songcount":16,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161222/20161222174316972456.jpg","intro":"就让这首歌，今夜一直重复，我们都没错，只是看清楚，原来不懂的事。","suid":509004809,"specialid":121230,"collectcount":34,"user_name":"小石头来也","slid":29},{"play_count":14594803,"specialname":"让人忍不住哼唱的经典老歌","publishtime":"2016-11-04","singername":"","verified":0,"songcount":21,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161104/20161104104645701194.jpg","intro":"最近喜欢老歌，每每听到，自己都会忍不住跟着哼唱，有些甚至一时喊不出名字！其实这样的老歌有很多，也许整理的不够全面，但是只是想把这种老歌的情怀分享给大家，听一些老歌曲，看一些老片子。可能是因为人老了吧！听着老歌，莫名的很安静，很幸福！","suid":509004219,"specialid":119881,"collectcount":3531,"user_name":"冷雨孤行","slid":26}],"icon":"http://imge.kugou.com/quickentry/20170225/20170225145441896239.png","id":4995}],"entry":[{"type":4,"imgurl":"http://imge.kugou.com/quickentry/20160330/20160330114622814737.png","title":"专区","extra":{"innerurl":"http://m.www2.kugou.com/yueku/category/area/entry.html"}},{"type":8,"imgurl":"http://imge.kugou.com/quickentry/20160325/20160325095053203269.png","title":"MV","extra":null},{"type":3,"imgurl":"http://imge.kugou.com/quickentry/20160418/20160418164539193695.png","title":"专题","extra":null},{"type":7,"imgurl":"http://imge.kugou.com/quickentry/20160418/20160418164515212880.png","title":"电台","extra":null}],"topic":[{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1IPhVBjAj1RCvBVdK.jpg","id":1633,"publishtime":"2017-01-24 11:45:00","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170120/20170120222523547522.jpg","title":"全新《歌手》之战残酷打响！","url":"http://activity.mobile.kugou.com/activity/singer2017/static/index.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170120/20170120222522529185.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1GkVcB7E_1RCvBVdK.jpg","id":1741,"publishtime":"2017-02-26 11:37:16","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170226/20170226113636934414.jpg","title":"Ed Sheeran专辑《÷》Divide开始预售","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170226/20170226113716932267.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1W4DcBKx_1RCvBVdK.jpg","id":1739,"publishtime":"2017-02-23 19:38:44","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170223/20170223193846135616.jpg","title":"音乐故事Vol.51:你可不可以...爱我？","url":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170223/20170223193845936060.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1iaWcB5_T1RCvBVdK.jpg","id":1731,"publishtime":"2017-02-21 13:09:03","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170221/20170221121649453689.jpg","title":"鹿晗全新数字专辑《Venture》重磅发售","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68909.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170221/20170221121648404184.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T18xYHB_J_1RCvBVdK.jpg","id":1723,"publishtime":"2017-02-20 10:04:42","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170220/20170220100444648908.jpg","title":"一盒子的民谣，一盒子的感动","url":"http://topic.mobile.kugou.com/content/?topic_id=68624&random=1487556218246064091","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170220/20170220100443558360.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1FXJcBmAg1RCvBVdK.jpg","id":1737,"publishtime":"2017-02-23 19:38:54","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170222/20170222150413700323.jpg","title":"给你好听Vol.48:致爱情路上成长蜕变的你","url":"http://topic.mobile.kugou.com/content/?topic_id=68994&random=1487745892255826580","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170222/20170222150412488455.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1ttEcBsDg1RCvBVdK.jpg","id":1727,"publishtime":"2017-02-21 02:54:40","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170221/20170221025441390147.jpg","title":"黄致列最新单曲《男女的温度差(feat.Kassy)》","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68897.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170221/20170221025150573634.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1MfCHBCLj1RCvBVdK.jpg","id":1721,"publishtime":"2017-02-17 14:10:39","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170217/20170217141040246750.jpg","title":"音乐故事Vol.50:再也回不去的那些年","url":"http://huodong.kugou.com/a2015/html/musicStory/index_68571.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170216/20170216202519729388.jpg","extra":null}]}}
     * error :
     */

    private int status;
    private int errcode;
    private DataBean data;
    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static class DataBean {
        /**
         * timestamp : 1488090137
         * info : {"recommend":[{"imgurl":"","title":"歌手2017 合辑","id":16095,"type":1,"online":1488038400,"extra":{"play_count":13230392,"specialname":"歌手2017 合辑","publishtime":"2017-02-19","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！","suid":509004464,"specialid":121575,"collectcount":30042,"user_name":"战战战","slid":27}},{"imgurl":"","title":"任何年龄段都会爱上的经典好歌","id":16097,"type":1,"online":1488038400,"extra":{"play_count":3523778,"specialname":"任何年龄段都会爱上的经典好歌","publishtime":"2017-02-23","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170223/20170223163949547794.jpg","intro":"管你什么80后90后00后，都会爱上这时光沉淀的美好情愫\u2026\u2026","suid":509005747,"specialid":122292,"collectcount":764,"user_name":"小胖","slid":29}},{"imgurl":"","title":"听粤语，品味歌词的细腻","id":16099,"type":1,"online":1488038400,"extra":{"play_count":323367,"specialname":"听粤语，品味歌词的细腻","publishtime":"2017-02-23","singername":"","verified":0,"songcount":49,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170223/20170223152747103319.jpg","intro":"听粤语，品味歌词的细腻。","suid":509005749,"specialid":122290,"collectcount":118,"user_name":"片刻诗意","slid":29}},{"imgurl":"","title":"一周超好听新歌","id":16101,"type":1,"online":1488038400,"extra":{"play_count":114433,"specialname":"一周超好听新歌(2017-02-24)","publishtime":"2017-02-24","singername":"","verified":0,"songcount":46,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170224/20170224212543651832.jpg","intro":"酷狗独家的歌手李佑晨发新歌啦！一首《庙会街上》，让我们对她有了全新的认识。而本周很多大牌的合作也引人关注，点进歌单，期待你与最美好的声音相遇！","suid":509005720,"specialid":122319,"collectcount":52,"user_name":"张玉宝","slid":28}},{"imgurl":"","title":"80后的集体回忆","id":16103,"type":1,"online":1488038400,"extra":{"play_count":64663195,"specialname":"80后的集体回忆","publishtime":"2016-11-29","singername":"","verified":0,"songcount":90,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150826/20150826103256242218.jpg","intro":"那些伴随我们成长而逐渐消散、珍藏在记忆里的美好怀念，不会随同岁月流逝。80后，十年的时间，产生多少经典，留下多少美好，我们都能从歌里听到。","suid":373452663,"specialid":25362,"collectcount":77033,"user_name":"彼岸花","slid":97}},{"imgurl":"","title":"小曲调，小清新","id":16105,"type":1,"online":1488038400,"extra":{"play_count":506838,"specialname":"小曲调，小清新","publishtime":"2017-02-21","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170221/20170221173435412732.jpg","intro":"曲风大都清爽自然、温暖感动、可爱唯美。","suid":509005801,"specialid":122238,"collectcount":642,"user_name":"可可玲儿","slid":29}},{"imgurl":"","title":"人生只若初见","id":16107,"type":1,"online":1488038400,"extra":{"play_count":564673,"specialname":"人生只若初见","publishtime":"2017-02-15","singername":"","verified":0,"songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215161028785597.jpg","intro":"终是谁使弦断，花落肩头，恍惚迷离，终只落下一段无果的缘，落得一句：\u201c人生只若初见。\u201d","suid":509005898,"specialid":122141,"collectcount":1256,"user_name":"冰雪凌","slid":27}},{"imgurl":"","title":"最动听的英文励志歌","id":16109,"type":1,"online":1488038400,"extra":{"play_count":8803878,"specialname":"最动听的英文励志歌","publishtime":"2016-11-28","singername":"","verified":0,"songcount":37,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150807/20150807194200801227.jpg","intro":"如果受到了伤害、遇到了挫折，不要害怕，还有音乐永远陪着你！","suid":656896302,"specialid":25917,"collectcount":24097,"user_name":"柠檬幽阁","slid":6}},{"imgurl":"","title":"用歌词说一个故事","id":16111,"type":1,"online":1488038400,"extra":{"play_count":2154193,"specialname":"用歌词说一个故事","publishtime":"2016-01-16","singername":"","verified":0,"songcount":53,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160116/20160116151918421508.jpg","intro":"当日子成为旧照片，当旧照片成为回忆，我们成了背对背行走的路人，沿着不同的方向固执地一步步远离。","suid":509001591,"specialid":57461,"collectcount":5102,"user_name":"夏至＊未至","slid":48}},{"imgurl":"","title":"唱一首远方的民谣","id":16113,"type":1,"online":1488038400,"extra":{"play_count":1530951,"specialname":"唱一首远方的民谣","publishtime":"2016-12-09","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161209/20161209151914967486.jpg","intro":"回忆总是那么的猝不及防，走过的街道曾有你的身影，路过的咖啡店有属于你独特的味道，翻开旧照才发现你已经离我远去。","suid":509005075,"specialid":120964,"collectcount":2499,"user_name":"柳云腾","slid":29}},{"imgurl":"","title":"你不再回忆，我忘了忘记","id":16115,"type":1,"online":1488038400,"extra":{"play_count":5343085,"specialname":"你不再回忆，我忘了忘记","publishtime":"2016-07-27","singername":"","verified":0,"songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160727/20160727151816156621.jpg","intro":"最美的不是下雨天而是曾与你躲过雨的屋檐\u2026","suid":509004933,"specialid":117167,"collectcount":1372,"user_name":"叮咚","slid":26}},{"imgurl":"","title":"失恋时才有体会的伤感音符","id":16117,"type":1,"online":1488038400,"extra":{"play_count":3135337,"specialname":"失恋时才有体会的伤感音符","publishtime":"2016-03-23","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150526/20150526162801448346.jpg","intro":"我们的爱情竟也走到了终点，可是你的影子却一直在我心里没离开过，悲伤的情绪像是毒瘤，蔓延入我的全身。在失恋这场破伤风里，难免会有悲伤和难过，不要隐藏不要抑制，听听这些失恋专属歌，以毒攻毒，或许会好很多。","suid":373452606,"specialid":25155,"collectcount":8479,"user_name":"通往地狱的火车","slid":99}},{"imgurl":"","title":"让你心情愉悦的清新小调","id":16119,"type":1,"online":1488038400,"extra":{"play_count":560129,"specialname":"让你心情愉悦的清新小调","publishtime":"2016-10-17","singername":"","verified":0,"songcount":32,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161017/20161017163928169877.jpg","intro":"让你心情愉悦的清新小调","suid":509004847,"specialid":119253,"collectcount":1562,"user_name":"蝶舞清风","slid":28}},{"imgurl":"","title":"藏在我手机里的英文好歌","id":16121,"type":1,"online":1488038400,"extra":{"play_count":54819928,"specialname":"藏在我手机里的英文好歌","publishtime":"2016-05-10","singername":"","verified":0,"songcount":87,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160511/20160511171756788560.jpg","intro":"英文，一直是我最喜欢的语言。它是灵魂深处的悸动，清楚，分明。它是远别于喧嚣的沉静，流淌在时间里，有些经典，有些传唱。它和电影，是我最喜欢的叙述方式，它不像是一种途径，更像是一扇窗，让你看得真切。在它的语言里，我遇见了用真实的情感来叙述，遇见来自生活，抑或来自内心的吟唱。","suid":509006090,"specialid":114010,"collectcount":52143,"user_name":"小李子","slid":24}},{"imgurl":"","title":"听到就会哼的熟悉旋律","id":16123,"type":1,"online":1488038400,"extra":{"play_count":2653335,"specialname":"听到就会哼的熟悉旋律","publishtime":"2016-01-30","singername":"","verified":0,"songcount":253,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160130/20160130191340608384.jpg","intro":"有些歌，第一次听就似曾相识；有些歌，已经多年没听；有些歌，早已听过却不知道原来是你\u2026\u2026","suid":509001388,"specialid":57897,"collectcount":6880,"user_name":"烟雨霏霏","slid":48}},{"imgurl":"","title":"我以为有一天我会忘记你","id":16125,"type":1,"online":1488038400,"extra":{"play_count":380644,"specialname":"我以为有一天我会忘记你","publishtime":"2015-05-14","singername":"","verified":0,"songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20151013/20151013142952758753.jpg","intro":"人都有一份孤独，再繁华的热闹，有一颗冷心观红尘，但唯独他，一眼洞穿你的清寂你的凉，一眼明白这世间所有的繁华不过是你和他身边的过眼云烟，他会在众人之间一眼看到你，然后读懂你，明白你，不似爱情，胜似爱情。","suid":509001400,"specialid":29839,"collectcount":365,"user_name":"筎礠愛妳","slid":7}},{"imgurl":"","title":"伴我成长的校园歌曲","id":16127,"type":1,"online":1488038400,"extra":{"play_count":21173787,"specialname":"伴我成长的校园歌曲","publishtime":"2016-05-30","singername":"","verified":0,"songcount":72,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160530/20160530172903312132.jpg","intro":"又是一年毕业季，还好，你也在这错漏百出的青春里；还好，这些校园民谣都曾经陪着我们度过青春。还好。我的青春里有你！毕业季，酷狗与你一起用音乐纪念青春。","suid":509004681,"specialid":115419,"collectcount":10272,"user_name":"伤痕","slid":26}},{"imgurl":"","title":"童年儿歌 童声飞扬","id":16129,"type":1,"online":1488038400,"extra":{"play_count":8519431,"specialname":"童年儿歌 童声飞扬","publishtime":"2016-11-29","singername":"","verified":0,"songcount":60,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150201/20150201192759915542.jpg","intro":"妈妈们看过来，这张歌单专为宝宝们准备，让它成为宝宝们的音乐启蒙歌单，让他们生活在梦幻的人间，在音乐中茁壮成长！","suid":373452674,"specialid":24208,"collectcount":15547,"user_name":"罗曼司","slid":80}},{"imgurl":"","title":"给生活一点温暖","id":16131,"type":1,"online":1488038400,"extra":{"play_count":2757842,"specialname":"给生活一点温暖","publishtime":"2016-08-29","singername":"","verified":0,"songcount":74,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160829/20160829151719538012.jpg","intro":"我或许败北，或许迷失自己，或许哪里也抵达不了，或许我已失去一切，任凭怎么挣扎也只能徒呼奈何，或许我只是徒然掬一把废墟灰烬，唯我一人蒙在鼓里，或许这里没有任何人把赌注下在我身上。无所谓。有一点是明确的：至少我有值得等待有值得寻求的东西。","suid":509006018,"specialid":118082,"collectcount":2451,"user_name":"妲己笑","slid":25}},{"imgurl":"","title":"忘了我忘不了你","id":16133,"type":1,"online":1488038400,"extra":{"play_count":314333,"specialname":"忘了我忘不了你","publishtime":"2017-01-31","singername":"","verified":0,"songcount":25,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170131/20170131222425201402.jpg","intro":"忘了我忘不了你。网络伤感歌曲为你诚意推荐。","suid":509004196,"specialid":121843,"collectcount":183,"user_name":"赤砂之蠍","slid":28}},{"imgurl":"","title":"不闹不躁的小资韩语歌","id":16135,"type":1,"online":1488038400,"extra":{"play_count":2834444,"specialname":"不闹不躁的小资韩语歌","publishtime":"2016-07-06","singername":"","verified":0,"songcount":134,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160706/20160706153955751121.jpg","intro":"自家小店用音乐，刚刚好。","suid":509005580,"specialid":116520,"collectcount":2085,"user_name":"独行","slid":26}},{"imgurl":"","title":"粤语金曲：时光流逝，愈发香醇","id":16137,"type":1,"online":1488038400,"extra":{"play_count":5186106,"specialname":"粤语金曲：时光流逝，愈发香醇","publishtime":"2017-02-06","singername":"","verified":0,"songcount":27,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206163935939826.jpg","intro":"谁说时间会抹去一切？至少这些存世的经典好歌并没有半点失色，再度回首，依旧在心中翻起一片波澜，也许你会说她老，但她却代表了一个时代，一段情怀。","suid":509006064,"specialid":121975,"collectcount":2299,"user_name":"笨笨的情","slid":29}},{"imgurl":"","title":"这些歌，你真的舍得删除吗","id":16139,"type":1,"online":1488038400,"extra":{"play_count":1208553,"specialname":"这些歌，你真的舍得删除吗","publishtime":"2017-02-06","singername":"","verified":0,"songcount":30,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206115506639690.jpg","intro":"这些百听不厌，万里挑一的歌曲，总是舍不得删除的经典歌曲，一次性呈现给大家！","suid":509006071,"specialid":121968,"collectcount":1845,"user_name":"毒龙","slid":29}},{"imgurl":"","title":"中文DJ热歌 至嗨舞曲","id":16141,"type":1,"online":1488038400,"extra":{"play_count":7906857,"specialname":"中文DJ热歌 至嗨舞曲","publishtime":"2017-01-12","singername":"","verified":0,"songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170109/20170109180126610978.jpg","intro":"网友最爱的中文DJ热歌，超嗨舞曲夜店热播！","suid":509004491,"specialid":121548,"collectcount":10651,"user_name":"放弃","slid":27}},{"imgurl":"","title":"夜店老司机 DJ热歌带你飞","id":16143,"type":1,"online":1488038400,"extra":{"play_count":1511540,"specialname":"夜店老司机 DJ热歌带你飞","publishtime":"2017-02-21","singername":"","verified":0,"songcount":45,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170221/20170221143708437981.jpg","intro":"夜店老司机来了！给你最嗨最火的夜店嗨歌！","suid":509005818,"specialid":122221,"collectcount":2090,"user_name":"飘然流水","slid":28}},{"imgurl":"","title":"挚爱华语深情女声","id":16145,"type":1,"online":1488038400,"extra":{"play_count":1989783,"specialname":"挚爱华语深情女声","publishtime":"2017-02-06","singername":"","verified":0,"songcount":37,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170206/20170206175116231795.jpg","intro":"\u201c那时，被触心的旋律吸引，但并不知道是你所唱；此刻，熟悉的旋律响起，才知道那时的相遇，是件多么幸运、多么美好的事情。\u201d写在开头，写给自己，写给那些美好的旧时光。","suid":509006053,"specialid":121986,"collectcount":2278,"user_name":"李彬","slid":29}},{"imgurl":"","title":"最经典狂热舞曲","id":16147,"type":1,"online":1488038400,"extra":{"play_count":37067268,"specialname":"最经典狂热舞曲","publishtime":"2013-10-08","singername":"","verified":0,"songcount":125,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160302/20160302133124542543.jpg","intro":"最狂热经典舞曲！","suid":509001143,"specialid":58838,"collectcount":24592,"user_name":"无语_sE2B1","slid":48}},{"imgurl":"","title":"唯有歌与酒，可以消寂寞","id":16149,"type":1,"online":1488038400,"extra":{"play_count":399698,"specialname":"唯有歌与酒，可以消寂寞","publishtime":"2015-09-01","singername":"","verified":0,"songcount":36,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150901/20150901174620849298.jpg","intro":"寂寞、孤独、痛苦\u2026\u2026治愈这些的良药，只有音乐和烟酒。","suid":509001564,"specialid":26163,"collectcount":2644,"user_name":"颜祖/:heart","slid":2}},{"imgurl":"","title":"怀念经典 致敬经典","id":16151,"type":1,"online":1488038400,"extra":{"play_count":12052107,"specialname":"怀念经典 致敬经典","publishtime":"2017-02-15","singername":"","verified":0,"songcount":44,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170215/20170215155929694880.jpg","intro":"那些耳熟能详的经典老歌，值得单曲循环。","suid":509005899,"specialid":122140,"collectcount":5651,"user_name":"江南","slid":29}},{"imgurl":"","title":"【耳朵怀孕】热评过万电音","id":16153,"type":1,"online":1488038400,"extra":{"play_count":29468585,"specialname":"【耳朵怀孕】热评过万电音","publishtime":"2016-07-15","singername":"","verified":0,"songcount":53,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20160716/20160716105415269821.jpg","intro":"每一首都是精选，过万人评论。此歌单我会持续更新！","suid":509005248,"specialid":116852,"collectcount":74243,"user_name":"混世枭雄","slid":26}}],"operation":[],"song":[{"filename":"张杰 - 哥哥","songname":"哥哥","sqhash":"547BEEB883FB32F3DC7DF14072D42BC4","hash":"67E7D056772F4FAE0747843D0A72375A","mvhash":"","privilege":0,"filesize":5736838,"addtime":"2017-02-25 18:34:10","bitrate":128,"320filesize":14343360,"Accompany":1,"isfirst":1,"singername":"张杰","sqfilesize":36095650,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170111/20170111104600449.jpg","duration":359,"m4afilesize":0,"extname":"mp3","320hash":"96A181792E2E96F1BDC7A03F9415CB27","sqprivilege":0,"intro":"","feetype":0},{"filename":"刘惜君 - 线","songname":"线","sqhash":"9CC080C7A31C636DD257021E90E8D242","hash":"97AFB411D2B6657B89B7F5563A748129","mvhash":"E4F93AD043ABD6E871258EE67F6064E3","privilege":0,"filesize":4406169,"addtime":"2017-02-21 12:09:03","bitrate":128,"320filesize":11015398,"Accompany":0,"isfirst":1,"singername":"刘惜君","sqfilesize":29236491,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20160429/20160429120406872.jpg","duration":275,"m4afilesize":0,"extname":"mp3","320hash":"18119BD8B4DFB547F1068728A6367918","sqprivilege":0,"intro":"","feetype":0},{"filename":"孙露 - 痛快人生","songname":"痛快人生","sqhash":"30C4AFD84A99E2EFEAFAA77B5BC2FA48","hash":"041332BF26D36D8CB2A7DA84CD8BFC83","mvhash":"","privilege":0,"filesize":4549399,"addtime":"2017-02-23 10:32:18","bitrate":127,"320filesize":11374759,"Accompany":1,"isfirst":1,"singername":"孙露","sqfilesize":28711725,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170221/20170221154248275887.jpg","duration":284,"m4afilesize":0,"extname":"mp3","320hash":"E53F82C5DA606863DD73298210B3D248","sqprivilege":0,"intro":"","feetype":0},{"filename":"戴佩妮 - 贼","songname":"贼","sqhash":"F4485C9009278724EC4593EB2425CE60","hash":"E51AD48CCE1C3607E3ADED93920858D7","mvhash":"9577AEDF6552B5CBF21CE106D531C959","privilege":0,"filesize":3511461,"addtime":"2016-08-04 17:36:46","bitrate":128,"320filesize":8778231,"Accompany":1,"isfirst":0,"singername":"戴佩妮","sqfilesize":25440255,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20160830/20160830172353700.jpg","duration":219,"m4afilesize":0,"extname":"mp3","320hash":"75D13B872FCF1A504493B91BAC8FEB63","sqprivilege":0,"intro":"","feetype":0},{"filename":"唐古 - 用尽一生爱你","songname":"用尽一生爱你","sqhash":"264C94DAF54084D63F2427A337A4AD9F","hash":"00C2291F8C3B70E3E5EDDBAA8658F2A1","mvhash":"A16A3C9D1DA25AC39B6B479E4EFAC61E","privilege":0,"filesize":4036564,"addtime":"2016-08-08 15:39:14","bitrate":128,"320filesize":10092669,"Accompany":1,"isfirst":1,"singername":"唐古","sqfilesize":30210139,"320privilege":0,"singerimgurl":"http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20161008/20161008114017219.jpg","duration":252,"m4afilesize":0,"extname":"mp3","320hash":"E4758AD2F05ECE98213BAA4B78D086BB","sqprivilege":0,"intro":"","feetype":0}],"vlist":[{"des":"第89届奥斯卡将于2月27日隆重举行！《爱乐之城》《雄狮》《星际迷航3》等众多电影获提名入围，精彩的故事再配上触动灵魂的配乐，神切入的旋律与步步推进的剧情交错相连，让人沉醉，现在就让我们一起欣赏本届奥斯卡提名电影的精彩配乐。","public_time":"2017/02/24","title":"第89届奥斯卡提名电影配乐合集","cate":"影视原声","vid":69567,"mobile_banner":"http://imge.kugou.com/commendpic/20170224/20170224184420299424.jpg","hot_num":1034},{"des":"情人节要来了！虐狗日要到了！单身无罪好么\u2026\u2026为了营造浓厚节日气氛，让大家都能感受到满满的爱，小编特意收集了一群甜到溢出屏幕的明星情侣MV，发现了一个大秘密，原来爱就是，他的眼里只有你！","public_time":"2017/02/14","title":"亲爱哒，我的眼里只有你！","cate":"特别策划","vid":68097,"mobile_banner":"http://imge.kugou.com/commendpic/20170213/20170213141522344064.jpg","hot_num":41373},{"des":"第59届格莱美奖火爆来袭！阿黛尔成为大赢家，五提五中！碧昂斯身怀双胞胎依然献上高难度表演！摇滚Ga大玩\u201c跳水\u201d嗨翻全场！还有众星联合舞台，致敬故人！超精彩的现场表演，不容错过！","public_time":"2017/02/13","title":"第59届格莱美奖精彩回顾","cate":"特别策划","vid":68091,"mobile_banner":"http://imge.kugou.com/commendpic/20170213/20170213123923845336.jpg","hot_num":31521},{"des":"2016年有哪些爆红的影视作品？！年初的《太阳的后裔》让全国男男女女天天喊宋老公。小鲜肉出演的各大IP影视作品让人应接不暇！爆米花电影当然不能少了欧美大片！它们这么红！你们一定看过！","public_time":"2017/02/05","title":"年终MV盘点：影视篇","cate":"影视原声","vid":65773,"mobile_banner":"http://imge.kugou.com/commendpic/20170205/20170205145200877434.jpg","hot_num":51228}],"album":[{"albumname":"歌手2017 第六期","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！","singerid":637338,"publishtime":"2017-02-25","singername":"歌手2017","albumid":1974548,"privilege":0},{"albumname":"徘徊","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170224/20170224174736660720.jpg","intro":"十二月，遇见王青\n\n在大众的眼中，王青是新生代艺人迅速崛起的象征，\n耀眼的光环和失控的尖叫，\n伴随着些许的争议和质疑一并而来\n外界赋予他的一切标签，反而让王青沉了下来，\n怀着淡然而绝决的心态，安静做着自己的计划，\n这目标并不宏伟，也不狂野，\n但他希望保留自己的风格，\n借助恰当的形式，去说一些想说的话，\n传达一种要表达的态度。\n\n作为新人，他永远保持着旺盛的求知欲，\n他热爱表演，努力将自己的灵魂浇灌至自己的角色；\n他也热爱音乐，想将他衷爱的旋律，用他的方式演绎；\n终于，现在，可以大声的说出自己的音乐态度。\n关于音乐，他有很多奇妙的想法。\n那些古典弦乐和潮流电音，\n那些循环的节奏和叠加的层次，\n他总能从中抓到一些不一样的小惊喜，\n带着些许的期待，\n悄悄地种在自己的音乐里。\n\n为了给自己一个满意的作品，\n王青坦言，每一个作品的完成对自己而言都是一次蜕变，\n诞生出一个新的不同的自己。\n当专辑最后一首歌录完，王青走出录音棚，\n他说，Not Bad，嗯，这感觉不错\n\n所以你能在这张《十二月》中听到一个不同风格、多元形态的王青，\n与你之前见到的都不一样\n他不试图复制自己，也不效仿他人，\n他只是希望把自己融入声音，唱自己想唱的歌，\n懂他的人，会懂。\n反复的打磨，出自匠心，匠意，\n呈现出来的终将是份诚意满满的心意，\n是DEMO在此刻的终结，\n又预示着另一种全新模式的开启。\n\n如果名字只能是代号和标签，\n那么他就要把自己拆解，\n细致淬炼，重塑最新的自己。\n每一首歌都代表不同的他，\n五个不同的故事，\n五种不同的阶段，\n不断进化，不断更新，\n多面且真实，\n十二月，让我们遇见王青","singerid":85715,"publishtime":"2017-02-25","singername":"王青","albumid":1974311,"privilege":0},{"albumname":"向天再要500话","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170224/20170224093333840556.jpg","intro":"腾讯动漫催更神曲 薛之谦魔性出演\n彩虹室内合唱团献声演唱\n追不完的海量日更，只在腾讯动漫APP","singerid":287581,"publishtime":"2017-02-24","singername":"上海彩虹室内合唱团","albumid":1973958,"privilege":0},{"albumname":"Where Do We Go(Soul Remix)","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170222/20170222111450744937.jpg","intro":"Lara梁心颐这次推出的单曲「Where Do We Go: SOUL REMIX」又让她踏进了一个全新领域。作为Lara的初次Soul/R&B风格体验，歌曲的有机live band氛围、充满爆发力的饶舌演出、和Lara表现上的突破，保证会让所有歌迷耳目一新。「Where Do We Go: SOUL REMIX」邀请了RoboKatz合作，制作人斐立普 Felipe Z.表示当初听到了「Where Do We Go」原版特别欣赏这首歌的旋律和气氛呈现，但因为喜欢用新角度诠释一首歌，他对「Where Do We Go」的欣赏，反而激发了动力去尝试台湾音乐市场少数能听到的风格。\n\n说到突破，「Where Do We Go: SOUL REMIX」也邀请了Robokatz Music旗下的饶舌歌手吕士轩（a.k.a.TroutFresh）来参与一段rap。来自于曾受过Amei张惠妹好评的独立乐团 SmashRegz/违法的他，独特的嗓音和rap flow让Remix多了层次。制作人Felipe 说TroutFresh的部分不只让歌更有张力跟生命力，也与Lara的甜嗓搭配的刚刚好 ，形成一钢一柔的绝妙组合。\n\nLara透露在制作「Where Do We Go」原版的过程中已经想要尝试加rap了，但因为想保留最纯粹的味道所以计划就先搁置了。身为有原版的词曲创作人之一，Lara第一次听到Robokatz制作的版本就马上情不自禁地露出微笑，表示新的编曲给了「Where Do We Go」一种万万没想到的新生命。「因为这首歌原曲是与Jason的编曲一起诞生的，所以在我脑海中它一直就是那个氛围。Robokatz与Troutfresh把原本冷清神秘的氛围加了温暖甚至活泼的成份，意外又惊喜。」\n\n因父亲喜好的关系，Lara从小耳濡目染的是Bob Dylan、Beatles这些音乐人，可以说摇滚和民谣才是她音乐的原点。后来为了「Where Do We Go: SOUL REMIX」她被Felipe逼出了很少尝试的R&B唱腔，甚至阔别十年再次跟饶舌歌手合作（上次是07年与MC Hotdog），再次地打破了从前被大公司保护着的偶像包袱，让大家知道她是懂得将嗓音变化自如的歌手，而且还能拓展到各种类型的音乐上，不会单单停滞在流行的领域当中。\n\n尤其在录完音后，她更加强对自己创作能力的信心了，因为有生命力的歌曲，不管用任何形式的类型重新编排，都会展现出它的特色。希望藉由「Where Do We Go: SOUL REMIX」让再临人间的迷途精灵Lara梁心颐，披露她蜕变后的全新姿态在你们的眼前。","singerid":83769,"publishtime":"2017-02-22","singername":"梁心颐","albumid":1973050,"privilege":0},{"albumname":"Venture","imgurl":"http://imge.kugou.com/stdmusic/{size}/20170221/20170221123906430252.jpg","intro":"时间是为了定位现在而创造的伪概念，人类像乘坐着宇宙中最快的交通工具，以不可思议的速度打败数字，进行迭代。而让我们进化的，是打破原本平稳无聊状态的欲望。\n千篇一律的风格、含糊不清的态度、语焉不详的说辞\u2026\u2026鹿晗站在这些的反面，玩一个粉碎无趣的游戏。守着山洞里的财宝固然安全，却也让骑士变成恶龙。是冒险家穿过未知海域发现新大陆，才让人看见世界的轮廓。鹿晗在每一次的音乐大航海里，燃烧着从不止步的冒险精神，让他区分于其他单薄的人设，成为混沌中令人一眼定睛的鲜活角色。\n《Venture》一如既往承担着开拓的责任，鹿晗经历种种而后成长，以锐利的音乐之刃切割迷雾，试图唱出更多人与人之间关系的结构，更深入寻找音乐的可能性。\n《如果 What if I said》精致的Contemporary R&B，时髦的情歌句型\n延续《某时某刻》的幕后阵容，由Santell和Picard Brothers（Maxme Picard与Clement Picard）为《如果 What if I said》担纲制作，以入耳即化的温柔旋律突出鹿晗的声音色彩，辅以更为犀利的电子音效，点破恋爱行至分崩离析时，「想触碰却收回手」的姿态。对你的舍不得，是在自己的对话框里任凭心情风起云涌，也克制地按下delete。这是我和你的关系里，我最后的秘密。\n相比于在恋爱的语境里充满过剩的情绪，鹿晗更善于用更为轻盈的叙事来展现当下年轻人的行事风格。学会接受爱的到来与消失，是成长的必经之路。《如果 What if I said》以精细的编曲和演唱方式，展现出梦幻而易碎的年轻人的恋爱形态和成长后的处理方式。\n《敢 Roleplay》态度重磅出击，有话直说的trap招式\n是不是经常会遇见不懂分寸、没有界限的人来打扰你的节奏？或者听见那些躲在暗处的偷窥癖咀嚼着你生活的细枝末，大放厥词？是不敢直视小丑的眼睛，对杂音习以为常，还是用真实的态度为自己想要的世界投票？\n全新歌曲《敢 Roleplay》用最时髦的trap曲风，通过犀利的rap，松弛而充满趣味的编曲，淋漓尽致地展现了鹿晗的耿直率性，哪怕在亿万人注视的镁光灯聚焦下，鹿晗也选择\u201c有话直说\u201d，用音乐坦诚表达，在现象里挖掘更多深意，为所有感同身受而唱。","singerid":173452,"publishtime":"2017-02-21","singername":"鹿晗","albumid":1972050,"privilege":10},{"albumname":"音乐大师课 第二季 第八期","imgurl":"http://imge.kugou.com/stdmusic/{size}/20160402/20160402152625445247.jpg","intro":"《音乐大师课》由世熙传媒联合北京卫视打造，由顶级音乐人教天赋少年唱经典歌曲，一档真正的少儿音乐成长节目。2016年\u201c第二学年\u201d正式开启！","singerid":187388,"publishtime":"2016-04-02","singername":"音乐大师课","albumid":1399575,"privilege":0}],"custom_special":[{"title":"主题歌单 · 那些你反复哼起的华语歌曲","special":[{"play_count":5156028,"specialname":"粤语好歌 值得反复聆听","publishtime":"2016-11-30","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161130/20161130175801678009.jpg","intro":"始终觉得删了可惜的歌哦！","suid":509005376,"specialid":120724,"collectcount":5684,"user_name":"天使的守护","slid":29},{"play_count":85223,"specialname":"那些引起人共鸣的循环单曲","publishtime":"2016-12-21","singername":"","verified":0,"songcount":16,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161222/20161222174316972456.jpg","intro":"就让这首歌，今夜一直重复，我们都没错，只是看清楚，原来不懂的事。","suid":509004809,"specialid":121230,"collectcount":34,"user_name":"小石头来也","slid":29},{"play_count":14594803,"specialname":"让人忍不住哼唱的经典老歌","publishtime":"2016-11-04","singername":"","verified":0,"songcount":21,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161104/20161104104645701194.jpg","intro":"最近喜欢老歌，每每听到，自己都会忍不住跟着哼唱，有些甚至一时喊不出名字！其实这样的老歌有很多，也许整理的不够全面，但是只是想把这种老歌的情怀分享给大家，听一些老歌曲，看一些老片子。可能是因为人老了吧！听着老歌，莫名的很安静，很幸福！","suid":509004219,"specialid":119881,"collectcount":3531,"user_name":"冷雨孤行","slid":26}],"icon":"http://imge.kugou.com/quickentry/20170225/20170225145441896239.png","id":4995}],"entry":[{"type":4,"imgurl":"http://imge.kugou.com/quickentry/20160330/20160330114622814737.png","title":"专区","extra":{"innerurl":"http://m.www2.kugou.com/yueku/category/area/entry.html"}},{"type":8,"imgurl":"http://imge.kugou.com/quickentry/20160325/20160325095053203269.png","title":"MV","extra":null},{"type":3,"imgurl":"http://imge.kugou.com/quickentry/20160418/20160418164539193695.png","title":"专题","extra":null},{"type":7,"imgurl":"http://imge.kugou.com/quickentry/20160418/20160418164515212880.png","title":"电台","extra":null}],"topic":[{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1IPhVBjAj1RCvBVdK.jpg","id":1633,"publishtime":"2017-01-24 11:45:00","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170120/20170120222523547522.jpg","title":"全新《歌手》之战残酷打响！","url":"http://activity.mobile.kugou.com/activity/singer2017/static/index.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170120/20170120222522529185.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1GkVcB7E_1RCvBVdK.jpg","id":1741,"publishtime":"2017-02-26 11:37:16","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170226/20170226113636934414.jpg","title":"Ed Sheeran专辑《÷》Divide开始预售","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_69486.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170226/20170226113716932267.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1W4DcBKx_1RCvBVdK.jpg","id":1739,"publishtime":"2017-02-23 19:38:44","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170223/20170223193846135616.jpg","title":"音乐故事Vol.51:你可不可以...爱我？","url":"http://huodong.kugou.com/a2015/html/musicStory/index_69423.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170223/20170223193845936060.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1iaWcB5_T1RCvBVdK.jpg","id":1731,"publishtime":"2017-02-21 13:09:03","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170221/20170221121649453689.jpg","title":"鹿晗全新数字专辑《Venture》重磅发售","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68909.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170221/20170221121648404184.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T18xYHB_J_1RCvBVdK.jpg","id":1723,"publishtime":"2017-02-20 10:04:42","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170220/20170220100444648908.jpg","title":"一盒子的民谣，一盒子的感动","url":"http://topic.mobile.kugou.com/content/?topic_id=68624&random=1487556218246064091","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170220/20170220100443558360.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1FXJcBmAg1RCvBVdK.jpg","id":1737,"publishtime":"2017-02-23 19:38:54","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170222/20170222150413700323.jpg","title":"给你好听Vol.48:致爱情路上成长蜕变的你","url":"http://topic.mobile.kugou.com/content/?topic_id=68994&random=1487745892255826580","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170222/20170222150412488455.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1ttEcBsDg1RCvBVdK.jpg","id":1727,"publishtime":"2017-02-21 02:54:40","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170221/20170221025441390147.jpg","title":"黄致列最新单曲《男女的温度差(feat.Kassy)》","url":"http://zhuanji.kugou.com/html/mobile_commonchargeV2/index_68897.html?is_go=1&hreffrom=10","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170221/20170221025150573634.jpg","extra":null},{"bannerhd":"http://imge.kugou.com/v2/mobiletopic/T1MfCHBCLj1RCvBVdK.jpg","id":1721,"publishtime":"2017-02-17 14:10:39","imgurl":"http://imge.kugou.com/mtopicbanner/{size}/20170217/20170217141040246750.jpg","title":"音乐故事Vol.50:再也回不去的那些年","url":"http://huodong.kugou.com/a2015/html/musicStory/index_68571.html","type":3,"picurl":"http://imge.kugou.com/mcommon/{size}/20170216/20170216202519729388.jpg","extra":null}]}
         */

        private int timestamp;
        private InfoBean info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            private List<RecommendBean> recommend;
            private List<?> operation;
            private List<SongBean> song;
            private List<VlistBean> vlist;
            private List<AlbumBean> album;
            private List<CustomSpecialBean> custom_special;
            private List<EntryBean> entry;
            private List<TopicBean> topic;

            public List<RecommendBean> getRecommend() {
                return recommend;
            }

            public void setRecommend(List<RecommendBean> recommend) {
                this.recommend = recommend;
            }

            public List<?> getOperation() {
                return operation;
            }

            public void setOperation(List<?> operation) {
                this.operation = operation;
            }

            public List<SongBean> getSong() {
                return song;
            }

            public void setSong(List<SongBean> song) {
                this.song = song;
            }

            public List<VlistBean> getVlist() {
                return vlist;
            }

            public void setVlist(List<VlistBean> vlist) {
                this.vlist = vlist;
            }

            public List<AlbumBean> getAlbum() {
                return album;
            }

            public void setAlbum(List<AlbumBean> album) {
                this.album = album;
            }

            public List<CustomSpecialBean> getCustom_special() {
                return custom_special;
            }

            public void setCustom_special(List<CustomSpecialBean> custom_special) {
                this.custom_special = custom_special;
            }

            public List<EntryBean> getEntry() {
                return entry;
            }

            public void setEntry(List<EntryBean> entry) {
                this.entry = entry;
            }

            public List<TopicBean> getTopic() {
                return topic;
            }

            public void setTopic(List<TopicBean> topic) {
                this.topic = topic;
            }

            public static class RecommendBean {
                /**
                 * imgurl :
                 * title : 歌手2017 合辑
                 * id : 16095
                 * type : 1
                 * online : 1488038400
                 * extra : {"play_count":13230392,"specialname":"歌手2017 合辑","publishtime":"2017-02-19","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg","intro":"乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！","suid":509004464,"specialid":121575,"collectcount":30042,"user_name":"战战战","slid":27}
                 */

                private String imgurl;
                private String title;
                private int id;
                private int type;
                private int online;
                private ExtraBean extra;

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public ExtraBean getExtra() {
                    return extra;
                }

                public void setExtra(ExtraBean extra) {
                    this.extra = extra;
                }

                public static class ExtraBean {
                    /**
                     * play_count : 13230392
                     * specialname : 歌手2017 合辑
                     * publishtime : 2017-02-19
                     * singername :
                     * verified : 0
                     * songcount : 47
                     * imgurl : http://imge.kugou.com/soft/collection/{size}/20170225/20170225222421828181.jpg
                     * intro : 乐过云巅，万念有心声，2017年1月21日起，每周六22：30锁定湖南卫视，《歌手》在等你！酷狗独家无损原声同步上线，与你共赴2017最强音乐盛宴！
                     * suid : 509004464
                     * specialid : 121575
                     * collectcount : 30042
                     * user_name : 战战战
                     * slid : 27
                     */

                    private int play_count;
                    private String specialname;
                    private String publishtime;
                    private String singername;
                    private int verified;
                    private int songcount;
                    private String imgurl;
                    private String intro;
                    private int suid;
                    private int specialid;
                    private int collectcount;
                    private String user_name;
                    private int slid;

                    public int getPlay_count() {
                        return play_count;
                    }

                    public void setPlay_count(int play_count) {
                        this.play_count = play_count;
                    }

                    public String getSpecialname() {
                        return specialname;
                    }

                    public void setSpecialname(String specialname) {
                        this.specialname = specialname;
                    }

                    public String getPublishtime() {
                        return publishtime;
                    }

                    public void setPublishtime(String publishtime) {
                        this.publishtime = publishtime;
                    }

                    public String getSingername() {
                        return singername;
                    }

                    public void setSingername(String singername) {
                        this.singername = singername;
                    }

                    public int getVerified() {
                        return verified;
                    }

                    public void setVerified(int verified) {
                        this.verified = verified;
                    }

                    public int getSongcount() {
                        return songcount;
                    }

                    public void setSongcount(int songcount) {
                        this.songcount = songcount;
                    }

                    public String getImgurl() {
                        return imgurl;
                    }

                    public void setImgurl(String imgurl) {
                        this.imgurl = imgurl;
                    }

                    public String getIntro() {
                        return intro;
                    }

                    public void setIntro(String intro) {
                        this.intro = intro;
                    }

                    public int getSuid() {
                        return suid;
                    }

                    public void setSuid(int suid) {
                        this.suid = suid;
                    }

                    public int getSpecialid() {
                        return specialid;
                    }

                    public void setSpecialid(int specialid) {
                        this.specialid = specialid;
                    }

                    public int getCollectcount() {
                        return collectcount;
                    }

                    public void setCollectcount(int collectcount) {
                        this.collectcount = collectcount;
                    }

                    public String getUser_name() {
                        return user_name;
                    }

                    public void setUser_name(String user_name) {
                        this.user_name = user_name;
                    }

                    public int getSlid() {
                        return slid;
                    }

                    public void setSlid(int slid) {
                        this.slid = slid;
                    }
                }
            }

            public static class SongBean {
                /**
                 * filename : 张杰 - 哥哥
                 * songname : 哥哥
                 * sqhash : 547BEEB883FB32F3DC7DF14072D42BC4
                 * hash : 67E7D056772F4FAE0747843D0A72375A
                 * mvhash :
                 * privilege : 0
                 * filesize : 5736838
                 * addtime : 2017-02-25 18:34:10
                 * bitrate : 128
                 * 320filesize : 14343360
                 * Accompany : 1
                 * isfirst : 1
                 * singername : 张杰
                 * sqfilesize : 36095650
                 * 320privilege : 0
                 * singerimgurl : http://singerimg.kugou.com/uploadpic/pass/softhead/{size}/20170111/20170111104600449.jpg
                 * duration : 359
                 * m4afilesize : 0
                 * extname : mp3
                 * 320hash : 96A181792E2E96F1BDC7A03F9415CB27
                 * sqprivilege : 0
                 * intro :
                 * feetype : 0
                 */

                private String filename;
                private String songname;
                private String sqhash;
                private String hash;
                private String mvhash;
                private int privilege;
                private int filesize;
                private String addtime;
                private int bitrate;
                @SerializedName("320filesize")
                private int value320filesize;
                private int Accompany;
                private int isfirst;
                private String singername;
                private int sqfilesize;
                @SerializedName("320privilege")
                private int value320privilege;
                private String singerimgurl;
                private int duration;
                private int m4afilesize;
                private String extname;
                @SerializedName("320hash")
                private String value320hash;
                private int sqprivilege;
                private String intro;
                private int feetype;

                public String getFilename() {
                    return filename;
                }

                public void setFilename(String filename) {
                    this.filename = filename;
                }

                public String getSongname() {
                    return songname;
                }

                public void setSongname(String songname) {
                    this.songname = songname;
                }

                public String getSqhash() {
                    return sqhash;
                }

                public void setSqhash(String sqhash) {
                    this.sqhash = sqhash;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public String getMvhash() {
                    return mvhash;
                }

                public void setMvhash(String mvhash) {
                    this.mvhash = mvhash;
                }

                public int getPrivilege() {
                    return privilege;
                }

                public void setPrivilege(int privilege) {
                    this.privilege = privilege;
                }

                public int getFilesize() {
                    return filesize;
                }

                public void setFilesize(int filesize) {
                    this.filesize = filesize;
                }

                public String getAddtime() {
                    return addtime;
                }

                public void setAddtime(String addtime) {
                    this.addtime = addtime;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getValue320filesize() {
                    return value320filesize;
                }

                public void setValue320filesize(int value320filesize) {
                    this.value320filesize = value320filesize;
                }

                public int getAccompany() {
                    return Accompany;
                }

                public void setAccompany(int Accompany) {
                    this.Accompany = Accompany;
                }

                public int getIsfirst() {
                    return isfirst;
                }

                public void setIsfirst(int isfirst) {
                    this.isfirst = isfirst;
                }

                public String getSingername() {
                    return singername;
                }

                public void setSingername(String singername) {
                    this.singername = singername;
                }

                public int getSqfilesize() {
                    return sqfilesize;
                }

                public void setSqfilesize(int sqfilesize) {
                    this.sqfilesize = sqfilesize;
                }

                public int getValue320privilege() {
                    return value320privilege;
                }

                public void setValue320privilege(int value320privilege) {
                    this.value320privilege = value320privilege;
                }

                public String getSingerimgurl() {
                    return singerimgurl;
                }

                public void setSingerimgurl(String singerimgurl) {
                    this.singerimgurl = singerimgurl;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public int getM4afilesize() {
                    return m4afilesize;
                }

                public void setM4afilesize(int m4afilesize) {
                    this.m4afilesize = m4afilesize;
                }

                public String getExtname() {
                    return extname;
                }

                public void setExtname(String extname) {
                    this.extname = extname;
                }

                public String getValue320hash() {
                    return value320hash;
                }

                public void setValue320hash(String value320hash) {
                    this.value320hash = value320hash;
                }

                public int getSqprivilege() {
                    return sqprivilege;
                }

                public void setSqprivilege(int sqprivilege) {
                    this.sqprivilege = sqprivilege;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public int getFeetype() {
                    return feetype;
                }

                public void setFeetype(int feetype) {
                    this.feetype = feetype;
                }
            }

            public static class VlistBean {
                /**
                 * des : 第89届奥斯卡将于2月27日隆重举行！《爱乐之城》《雄狮》《星际迷航3》等众多电影获提名入围，精彩的故事再配上触动灵魂的配乐，神切入的旋律与步步推进的剧情交错相连，让人沉醉，现在就让我们一起欣赏本届奥斯卡提名电影的精彩配乐。
                 * public_time : 2017/02/24
                 * title : 第89届奥斯卡提名电影配乐合集
                 * cate : 影视原声
                 * vid : 69567
                 * mobile_banner : http://imge.kugou.com/commendpic/20170224/20170224184420299424.jpg
                 * hot_num : 1034
                 */

                private String des;
                private String public_time;
                private String title;
                private String cate;
                private int vid;
                private String mobile_banner;
                private int hot_num;

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getPublic_time() {
                    return public_time;
                }

                public void setPublic_time(String public_time) {
                    this.public_time = public_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCate() {
                    return cate;
                }

                public void setCate(String cate) {
                    this.cate = cate;
                }

                public int getVid() {
                    return vid;
                }

                public void setVid(int vid) {
                    this.vid = vid;
                }

                public String getMobile_banner() {
                    return mobile_banner;
                }

                public void setMobile_banner(String mobile_banner) {
                    this.mobile_banner = mobile_banner;
                }

                public int getHot_num() {
                    return hot_num;
                }

                public void setHot_num(int hot_num) {
                    this.hot_num = hot_num;
                }
            }

            public static class AlbumBean {
                /**
                 * albumname : 歌手2017 第六期
                 * imgurl : http://imge.kugou.com/stdmusic/{size}/20170225/20170225183144852289.jpg
                 * intro : 乐过云巅，万念有心声，2017年1月21日起，锁定湖南卫视每周六晚22:30，《歌手2017》在等你！
                 * singerid : 637338
                 * publishtime : 2017-02-25
                 * singername : 歌手2017
                 * albumid : 1974548
                 * privilege : 0
                 */

                private String albumname;
                private String imgurl;
                private String intro;
                private int singerid;
                private String publishtime;
                private String singername;
                private int albumid;
                private int privilege;

                public String getAlbumname() {
                    return albumname;
                }

                public void setAlbumname(String albumname) {
                    this.albumname = albumname;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public int getSingerid() {
                    return singerid;
                }

                public void setSingerid(int singerid) {
                    this.singerid = singerid;
                }

                public String getPublishtime() {
                    return publishtime;
                }

                public void setPublishtime(String publishtime) {
                    this.publishtime = publishtime;
                }

                public String getSingername() {
                    return singername;
                }

                public void setSingername(String singername) {
                    this.singername = singername;
                }

                public int getAlbumid() {
                    return albumid;
                }

                public void setAlbumid(int albumid) {
                    this.albumid = albumid;
                }

                public int getPrivilege() {
                    return privilege;
                }

                public void setPrivilege(int privilege) {
                    this.privilege = privilege;
                }
            }

            public static class CustomSpecialBean {
                /**
                 * title : 主题歌单 · 那些你反复哼起的华语歌曲
                 * special : [{"play_count":5156028,"specialname":"粤语好歌 值得反复聆听","publishtime":"2016-11-30","singername":"","verified":0,"songcount":47,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161130/20161130175801678009.jpg","intro":"始终觉得删了可惜的歌哦！","suid":509005376,"specialid":120724,"collectcount":5684,"user_name":"天使的守护","slid":29},{"play_count":85223,"specialname":"那些引起人共鸣的循环单曲","publishtime":"2016-12-21","singername":"","verified":0,"songcount":16,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161222/20161222174316972456.jpg","intro":"就让这首歌，今夜一直重复，我们都没错，只是看清楚，原来不懂的事。","suid":509004809,"specialid":121230,"collectcount":34,"user_name":"小石头来也","slid":29},{"play_count":14594803,"specialname":"让人忍不住哼唱的经典老歌","publishtime":"2016-11-04","singername":"","verified":0,"songcount":21,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20161104/20161104104645701194.jpg","intro":"最近喜欢老歌，每每听到，自己都会忍不住跟着哼唱，有些甚至一时喊不出名字！其实这样的老歌有很多，也许整理的不够全面，但是只是想把这种老歌的情怀分享给大家，听一些老歌曲，看一些老片子。可能是因为人老了吧！听着老歌，莫名的很安静，很幸福！","suid":509004219,"specialid":119881,"collectcount":3531,"user_name":"冷雨孤行","slid":26}]
                 * icon : http://imge.kugou.com/quickentry/20170225/20170225145441896239.png
                 * id : 4995
                 */

                private String title;
                private String icon;
                private int id;
                private List<SpecialBean> special;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public List<SpecialBean> getSpecial() {
                    return special;
                }

                public void setSpecial(List<SpecialBean> special) {
                    this.special = special;
                }

                public static class SpecialBean implements Parcelable {
                    /**
                     * play_count : 5156028
                     * specialname : 粤语好歌 值得反复聆听
                     * publishtime : 2016-11-30
                     * singername :
                     * verified : 0
                     * songcount : 47
                     * imgurl : http://imge.kugou.com/soft/collection/{size}/20161130/20161130175801678009.jpg
                     * intro : 始终觉得删了可惜的歌哦！
                     * suid : 509005376
                     * specialid : 120724
                     * collectcount : 5684
                     * user_name : 天使的守护
                     * slid : 29
                     */

                    private int play_count;
                    private String specialname;
                    private String publishtime;
                    private String singername;
                    private int verified;
                    private int songcount;
                    private String imgurl;
                    private String intro;
                    private int suid;
                    private int specialid;
                    private int collectcount;
                    private String user_name;
                    private int slid;

                    public int getPlay_count() {
                        return play_count;
                    }

                    public void setPlay_count(int play_count) {
                        this.play_count = play_count;
                    }

                    public String getSpecialname() {
                        return specialname;
                    }

                    public void setSpecialname(String specialname) {
                        this.specialname = specialname;
                    }

                    public String getPublishtime() {
                        return publishtime;
                    }

                    public void setPublishtime(String publishtime) {
                        this.publishtime = publishtime;
                    }

                    public String getSingername() {
                        return singername;
                    }

                    public void setSingername(String singername) {
                        this.singername = singername;
                    }

                    public int getVerified() {
                        return verified;
                    }

                    public void setVerified(int verified) {
                        this.verified = verified;
                    }

                    public int getSongcount() {
                        return songcount;
                    }

                    public void setSongcount(int songcount) {
                        this.songcount = songcount;
                    }

                    public String getImgurl() {
                        return imgurl;
                    }

                    public void setImgurl(String imgurl) {
                        this.imgurl = imgurl;
                    }

                    public String getIntro() {
                        return intro;
                    }

                    public void setIntro(String intro) {
                        this.intro = intro;
                    }

                    public int getSuid() {
                        return suid;
                    }

                    public void setSuid(int suid) {
                        this.suid = suid;
                    }

                    public int getSpecialid() {
                        return specialid;
                    }

                    public void setSpecialid(int specialid) {
                        this.specialid = specialid;
                    }

                    public int getCollectcount() {
                        return collectcount;
                    }

                    public void setCollectcount(int collectcount) {
                        this.collectcount = collectcount;
                    }

                    public String getUser_name() {
                        return user_name;
                    }

                    public void setUser_name(String user_name) {
                        this.user_name = user_name;
                    }

                    public int getSlid() {
                        return slid;
                    }

                    public void setSlid(int slid) {
                        this.slid = slid;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(this.play_count);
                        dest.writeString(this.specialname);
                        dest.writeString(this.publishtime);
                        dest.writeString(this.singername);
                        dest.writeInt(this.verified);
                        dest.writeInt(this.songcount);
                        dest.writeString(this.imgurl);
                        dest.writeString(this.intro);
                        dest.writeInt(this.suid);
                        dest.writeInt(this.specialid);
                        dest.writeInt(this.collectcount);
                        dest.writeString(this.user_name);
                        dest.writeInt(this.slid);
                    }

                    public SpecialBean() {
                    }

                    protected SpecialBean(Parcel in) {
                        this.play_count = in.readInt();
                        this.specialname = in.readString();
                        this.publishtime = in.readString();
                        this.singername = in.readString();
                        this.verified = in.readInt();
                        this.songcount = in.readInt();
                        this.imgurl = in.readString();
                        this.intro = in.readString();
                        this.suid = in.readInt();
                        this.specialid = in.readInt();
                        this.collectcount = in.readInt();
                        this.user_name = in.readString();
                        this.slid = in.readInt();
                    }

                    public static final Parcelable.Creator<SpecialBean> CREATOR = new Parcelable.Creator<SpecialBean>() {
                        @Override
                        public SpecialBean createFromParcel(Parcel source) {
                            return new SpecialBean(source);
                        }

                        @Override
                        public SpecialBean[] newArray(int size) {
                            return new SpecialBean[size];
                        }
                    };
                }
            }

            public static class EntryBean {
                /**
                 * type : 4
                 * imgurl : http://imge.kugou.com/quickentry/20160330/20160330114622814737.png
                 * title : 专区
                 * extra : {"innerurl":"http://m.www2.kugou.com/yueku/category/area/entry.html"}
                 */

                private int type;
                private String imgurl;
                private String title;
                private ExtraBeanX extra;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public ExtraBeanX getExtra() {
                    return extra;
                }

                public void setExtra(ExtraBeanX extra) {
                    this.extra = extra;
                }

                public static class ExtraBeanX {
                    /**
                     * innerurl : http://m.www2.kugou.com/yueku/category/area/entry.html
                     */

                    private String innerurl;

                    public String getInnerurl() {
                        return innerurl;
                    }

                    public void setInnerurl(String innerurl) {
                        this.innerurl = innerurl;
                    }
                }
            }

            public static class TopicBean {
                /**
                 * bannerhd : http://imge.kugou.com/v2/mobiletopic/T1IPhVBjAj1RCvBVdK.jpg
                 * id : 1633
                 * publishtime : 2017-01-24 11:45:00
                 * imgurl : http://imge.kugou.com/mtopicbanner/{size}/20170120/20170120222523547522.jpg
                 * title : 全新《歌手》之战残酷打响！
                 * url : http://activity.mobile.kugou.com/activity/singer2017/static/index.html
                 * type : 3
                 * picurl : http://imge.kugou.com/mcommon/{size}/20170120/20170120222522529185.jpg
                 * extra : null
                 */

                private String bannerhd;
                private int id;
                private String publishtime;
                private String imgurl;
                private String title;
                private String url;
                private int type;
                private String picurl;
                private Object extra;

                public String getBannerhd() {
                    return bannerhd;
                }

                public void setBannerhd(String bannerhd) {
                    this.bannerhd = bannerhd;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPublishtime() {
                    return publishtime;
                }

                public void setPublishtime(String publishtime) {
                    this.publishtime = publishtime;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getPicurl() {
                    return picurl;
                }

                public void setPicurl(String picurl) {
                    this.picurl = picurl;
                }

                public Object getExtra() {
                    return extra;
                }

                public void setExtra(Object extra) {
                    this.extra = extra;
                }
            }
        }
    }
}
