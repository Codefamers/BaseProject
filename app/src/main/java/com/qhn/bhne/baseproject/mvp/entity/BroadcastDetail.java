package com.qhn.bhne.baseproject.mvp.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qhn
 * on 2017/2/26 0026.
 */
public class BroadcastDetail {

    /**
     * status : 1
     * data : [{"heat":"0","isnew":"0","fmname":"ä¸\u0096ç\u0095\u008cçº§ç\u0083­é\u0097¨å\u008d\u0095æ\u009b²","fmid":"839","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20160929155356250137.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20160929155355609701.jpg","offset":528,"addtime":"2016-09-21 14:45:09","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"18A8B9C8153D6213A0CA261A56273091","size_ape":0,"sid":609034,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":3480763,"hash_ape":"","320size":8699820,"320hash":"1FC0B40C1F625DC48EF7121395F7B09E","time":217000,"bitrate":128,"320isfilehead":100,"320time":217000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"Jason Derulo - Trumpets","pkg_price_128":0}],"description":"æ²¡å\u0090¬è¿\u0087ä½ å°±OUTäº\u0086ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"KTVå¿\u0085ç\u0082¹æ\u009b²","fmid":"73","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20150406220812189205.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20150406220811212178.jpg","offset":1068,"addtime":"2012-04-06 11:31:04","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"66AC55011D107BDB1CCE1F871E6C57E9","size_ape":28437416,"sid":228456,"pay_type_128":0,"m4asize":1000779,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"80796ff3dd95a6edff8266919c6020e4","price_128":0,"fail_process_320":0,"topic_url":"","size":3810510,"hash_ape":"FA0E2FC5AFABDBEB40678CB1BC5506A4","320size":9524430,"320hash":"F9FD74BE5254E2D721435FE56F7446ED","time":238000,"bitrate":128,"320isfilehead":100,"320time":238080,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"è\u0090§æ½\u0087 - ç\u0088±è¦\u0081å\u009d¦è\u008d¡è\u008d¡","pkg_price_128":0}],"description":"æ\u0080»æ\u009c\u0089é\u0082£ä¹\u0088ä¸\u0080äº\u009bæ­\u008cï¼\u008cå\u0088°KTVæ\u0089\u008dæ\u0083³èµ·æ\u009d¥å\u008e\u009fæ\u009d¥é\u0082£ä¹\u0088å¥½å\u0090¬ã\u0080\u0082KTVç\u0083­å\u0094±å¥½æ­\u008cï¼\u008cä¸\u0080ç½\u0091æ\u0089\u0093å°½ï¼\u0081é\u0087\u008aæ\u0094¾å\u008e\u008bå\u008a\u009bï¼\u008cè\u0088\u008dæ\u0088\u0091å\u0085¶è°\u0081ï¼\u008cæ\u0088\u0091å¥\u008fæ\u0098¯éº¦é\u009c¸ï¼\u0081"},{"heat":"76","isnew":"0","fmname":"é\u0085·ç\u008b\u0097ç\u0083­æ­\u008c","fmid":"1","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20150406220849739772.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20150406220847934761.jpg","offset":3213,"addtime":"2011-09-01 18:15:51","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"22B0EB230AE7C73AD4F5A4B10C1F7F14","size_ape":0,"sid":578220,"pay_type_128":0,"m4asize":0,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"","price_128":0,"fail_process_320":0,"topic_url":"","size":3780672,"hash_ape":"","320size":9675840,"320hash":"6CAAF6DB2AD05D4867EE3282FCD8DE01","time":241000,"bitrate":128,"320isfilehead":100,"320time":242000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"è\u0092\u008bæ\u0095¦è±ª - æ²³æµ\u0081(Live)","pkg_price_128":0}],"description":"é\u009b\u0086å\u0090\u0088å½\u0093å\u0089\u008dæ\u009c\u0080æµ\u0081è¡\u008cã\u0080\u0081æ\u009c\u0080ç\u0083­é\u0097¨ç\u009a\u0084å¥½å\u0090¬æ­\u008cæ\u009b²ï¼\u008cç\u0094±ä¸\u0093ä¸\u009aç\u009a\u0084é\u0085·ç\u008b\u0097æ\u0095°äº¿ç\u0094¨æ\u0088·ç\u009a\u0084è¯\u0095å\u0090¬æ\u0092­æ\u0094¾æ\u0095°æ\u008d®ç»\u009fè®¡æ\u0094¯æ\u008c\u0081ï¼\u008cæ\u008e¨è\u008d\u0090ç\u008e\u0087è¾¾å\u0088°ç\u0099¾å\u0088\u0086ä¹\u008bç\u0099¾å\u0093¦ï¼\u0081"},{"heat":"76","isnew":"0","fmname":"ç½\u0091ç»\u009cçº¢æ­\u008c","fmid":"2","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20150406221436526255.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20150406221436396960.jpg","offset":959,"addtime":"2011-09-01 18:40:39","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"EC5336C45CBCDCAB92FE996D113541F1","size_ape":0,"sid":371298,"pay_type_128":0,"m4asize":782643,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":3041906,"hash_ape":"","320size":7603721,"320hash":"DF86C755FB93E9ADF56C3DF1A4B9E9E1","time":190000,"bitrate":128,"320isfilehead":99,"320time":190000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"3CBB3567A4FB5001836B440171B0A68F","name":"ç\u008e\u008béº\u009f - å\u0090\u008eæ\u009d¥æ\u0088\u0091æ\u0089\u008dæ\u0087\u0082","pkg_price_128":0}],"description":"æ\u009c\u0080ç\u0081«ç\u0088\u0086ç\u009a\u0084ç½\u0091ç»\u009cçº¢æ­\u008cï¼\u008cæ\u009c\u0080è´´è¿\u0091ä½ ç\u009a\u0084ç\u0094\u009fæ´»ã\u0080\u0082å¹³æ°\u0091å\u008c\u0096ç\u009a\u0084é\u009f³ä¹\u0090ã\u0080\u0081å¹³æ°\u0091å\u008c\u0096ç\u009a\u0084æ­\u008cæ\u0089\u008bï¼\u008cä¸ºæ\u0082¨æ\u0089\u0093é\u0080 ä¸\u0080ä¸ªæ\u009c\u0080æ\u008e¥å\u009c°æ°\u0094å\u0084¿ç\u009a\u0084ç©ºé\u0097´ã\u0080\u0082"},{"heat":"26","isnew":"0","fmname":"ä¸­æ\u0096\u0087ç»\u008få\u0085¸","fmid":"5","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140310195328692622.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140310195328185073.jpg","offset":689,"addtime":"2011-09-01 18:45:41","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"46C2C47B500D149B577BABC0B6B4A6EB","size_ape":23773543,"sid":297865,"pay_type_128":0,"m4asize":879916,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"3dde596070f36b6301c2fe68e461949d","price_128":0,"fail_process_320":12,"topic_url":"","size":3378364,"hash_ape":"27D5007AC3FE9D1E3304D6E17B1C125C","320size":8369830,"320hash":"189851A463521CC39238D961E1B0173D","time":211122,"bitrate":128,"320isfilehead":100,"320time":209000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"154AC4071C2F16F79E793FCAA6498A44","name":"Twins - è\u008e«æ\u0096¯ç§\u0091æ²¡æ\u009c\u0089ç\u009c¼æ³ª","pkg_price_128":0}],"description":"æ\u0098\u0094æ\u0097¥ç\u009a\u0084è\u008a³å\u008d\u008eã\u0080\u0081é\u0099\u0088æ\u0097§ç\u009a\u0084ç¾\u008eä¸½ã\u0080\u0082ç©¿è¶\u008aæ\u0097¶ç©ºç\u0095\u008cé\u0099\u0090ï¼\u008cæ\u0084\u009få\u008f\u0097é\u0082£ä»½ä¹\u0085è¿\u009dç\u009a\u0084æ\u0080\u0080å¿µå¿\u0083æ\u0083\u0085ï¼\u008cé\u0082£æ®µæ\u009b¾ä»¤ä½ å¦\u0082ç\u0097´å¦\u0082é\u0086\u0089ç\u009a\u0084ä¼\u0098ç¾\u008eæ\u0097\u008bå¾\u008bã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"ä¼¤æ\u0084\u009fç½\u0091ç»\u009cæ\u0083\u0085æ­\u008c","fmid":"268","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20160530193748471727.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140816021542994078.jpg","offset":772,"addtime":"2014-08-11 10:40:59","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"35498F041F707B1E94F1B91B89A80BEB","size_ape":28217792,"sid":318525,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":4113971,"hash_ape":"030AD3EC78A80174E0A643AAF50B00CB","320size":10284929,"320hash":"8E8D76E6F8FB7D54E1BACFD7CF69FD11","time":257000,"bitrate":128,"320isfilehead":100,"320time":257000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"ç«¥å\u008f¯å\u008f¯ - ç¼ºå¸­","pkg_price_128":0}],"description":"æ²¡æ\u009c\u0089å\u008d\u008eä¸½ç\u009a\u0084æ\u008a\u0080å·§ï¼\u008cæ²¡æ\u009c\u0089å¼ºå¤§ç\u009a\u0084é\u0098µå®¹ï¼\u008cæ\u009c\u0089ç\u009a\u0084å\u008fªæ\u0098¯ç\u009b´æ\u008e¥ç\u009c\u009få®\u009eç\u009a\u0084æ\u0083\u0085æ\u0084\u009fï¼\u008cå\u0094±ç\u009a\u0084é\u0083½æ\u0098¯æ\u009c\u0080å¹³å®\u009eï¼\u008cæ\u009c\u0080æ\u0097 æ\u009a\u0087ï¼\u008cæ\u009c\u0080ç®\u0080å\u008d\u0095ç\u009a\u0084ï¼\u008cç\u0088±æ\u0083\u0085ï¼\u0081"},{"heat":"0","isnew":"0","fmname":"è\u0080\u0081æ\u0083\u0085æ­\u008c","fmid":"276","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140829193120436479.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140829193120220958.jpg","offset":389,"addtime":"2014-08-25 14:42:31","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"D1A9C6E4BDAC2B5F9BF8AF1BE2F5C55D","size_ape":28122974,"sid":336509,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"d7f0b1ee77a4fc0eca10a462eab296f4","price_128":0,"fail_process_320":12,"topic_url":"","size":4163914,"hash_ape":"8EA704BEFE3A99D5A36F37E7CBF84C36","320size":10411863,"320hash":"1EF7CF5187F5FD0843020D64F36F36AC","time":260000,"bitrate":128,"320isfilehead":100,"320time":260000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"å\u0091¨æ\u0085§æ\u0095\u008f - å¦\u0082æ\u009e\u009cä½ ç\u009f¥æ\u0088\u0091è\u008b¦è¡·","pkg_price_128":0}],"description":"ç©¿è¿\u0087å\u008e\u009aå®\u009eç\u009a\u0084å²\u0081æ\u009c\u0088ä»\u008då\u008a¨å\u0090¬ç\u009a\u0084æ­\u008cæ\u009b²ï¼\u008cä¸\u0080å\u0090¬ä¾¿è\u0083½å\u008b¾èµ·ä½ è\u0084\u0091æµ·é\u0087\u008cæ\u009b¾ç»\u008fç\u009a\u0084æ\u0097\u008bå¾\u008bï¼\u008cå\u008b¾èµ·ä¸\u0080å¹\u0095å¹\u0095å¾\u0080äº\u008bï¼\u008cæ\u0083\u0085æ­\u008cè¿\u0098æ\u0098¯è\u0080\u0081ç\u009a\u0084å¥½â\u0080¦"},{"heat":"0","isnew":"0","fmname":"ç¥\u009eæ\u009b²","fmid":"144","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20131023164214507637.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20131023164214281700.jpg","offset":94,"addtime":"2013-10-23 11:41:49","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"1972F6DD1806018F33C5CC39491B5C76","size_ape":0,"sid":435252,"pay_type_128":0,"m4asize":0,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"","price_128":0,"fail_process_320":0,"topic_url":"","size":1541267,"hash_ape":"","320size":3814922,"320hash":"FFB45D852A3542BF8618B4394491BA83","time":95000,"bitrate":128,"320isfilehead":100,"320time":95000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"é\u0087\u008då°\u008fç\u0083\u009f - å¤§ç\u008e\u008bå\u008f«æ\u0088\u0091æ\u009d¥å·¡å±±","pkg_price_128":0}],"description":"æ\u009b²é£\u008eé\u009b·äººï¼\u008cæ\u0097\u008bå¾\u008bä¸\u008aè\u0084\u0091ï¼\u008cè\u008a\u0082å¥\u008fç®\u0080å\u008d\u0095é²\u009cæ\u0098\u008eï¼\u008cè¿\u0099äº\u009bç¥\u009eæ\u009b²ï¼\u008cä»¥äººæ°\u0094åº¦å\u0092\u008cä¼ å\u0094±åº¦å\u008f\u0096è\u0083\u009cï¼\u008cè®©ä½ å\u0090¬å\u0088°æ ¹æ\u009c¬å°±å\u0081\u009cä¸\u008dä¸\u008bæ\u009d¥ã\u0080\u0082"},{"heat":"51","isnew":"0","fmname":"é\u0085·ç\u008b\u0097æ\u0096°æ­\u008c","fmid":"4","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20150409163804682333.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20150409163804543761.jpg","offset":787,"addtime":"2011-09-01 18:45:28","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"36EF1D6030DFC78DA71E8639AE9C6CAD","size_ape":0,"sid":497275,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"74C3AFBA8C7A5B91AD673324571CBA28","price_128":0,"fail_process_320":12,"topic_url":"","size":4203355,"hash_ape":"","320size":10505511,"320hash":"1D55FFAB84C93CCC73B86C53102D8C52","time":263000,"bitrate":128,"320isfilehead":100,"320time":262000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"Flumeã\u0080\u0081Tove Lo - Say It","pkg_price_128":0}],"description":"äº\u0091é\u009b\u0086æ\u0097¶ä¸\u008bæ\u009c\u0080æ\u0096°æ\u009c\u0080ç\u0083­æ\u009c\u0080æ½®ç\u009a\u0084æ­\u008cæ\u009b²ï¼\u008cé\u009f³ä¹\u0090é£\u008eæ ¼å\u0090\u0084å¼\u0082ï¼\u008cå\u008c\u0085ç½\u0097ä¸\u0087è±¡ã\u0080\u0082è®©ä½ äº«å\u008f\u0097é\u0085·ç\u008b\u0097ä¸\u0093ä¸\u009aç\u009a\u0084æ\u009c\u0080æ\u0096°æ\u008e¨è\u008d\u0090ï¼\u008cæ\u008a\u008aæ\u008f¡è\u0080³æ ¹æ½®æµ\u0081ç\u009a\u0084å°\u0096ç«¯ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"æ\u009c\u0080ç\u0088±æ\u0088\u0090å\u0090\u008dæ\u009b²","fmid":"63","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20150406220936447211.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20150406220936157132.jpg","offset":549,"addtime":"2012-01-09 14:57:47","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"FD2E0859A5A07DBA880027D62B7A906A","size_ape":24339556,"sid":236195,"pay_type_128":0,"m4asize":984937,"pkg_price_320":0,"privilege_128":0,"vip":1,"mvhash":"0F56007D415BE1A8E9F2993F8222D75E","price_128":0,"fail_process_320":0,"topic_url":"","size":3749929,"hash_ape":"6C09956CEC6CD74C1D3218C74EC6B996","320size":9278883,"320hash":"0DF66097DB60F77F0935EEA0601618AF","time":234371,"bitrate":128,"320isfilehead":100,"320time":231942,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"å¼ æ\u0095¬è½© - é\u0085·ç\u0088±","pkg_price_128":0}],"description":"ä¸\u0080é¦\u0096æ­\u008cè¹¿çº¢äº\u0086ä¸\u0080ä¸ªäººï¼\u008cä¸\u0080é¦\u0096æ\u009b²æ\u0089¿è½½äº\u0086ä¸\u0080ä¸ªæ\u0097¶ä»£ã\u0080\u0082ä¹\u0090å\u009d\u009bæ­\u008cæ\u0089\u008bç\u009a\u0084æ\u0088\u0090å\u0090\u008dé\u0087\u0091æ\u009b²ï¼\u008cæ\u0098¯å\u0090¦æ\u009b¾æ\u0089\u0093å\u008a¨ä½ ç\u009a\u0084å¿\u0083ï¼\u008cè®©ä½ å¯¹å®\u0083æ\u0097 æ³\u0095å¿\u0098æ\u0080\u0080ï¼\u009f"},{"heat":"0","isnew":"0","fmname":"ç»\u008få\u0085¸ç¿»å\u0094±","fmid":"254","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140714104551324533.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140714104551897307.jpg","offset":119,"addtime":"2014-07-04 15:28:37","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"hash_ape":"3FF140AA82C4ED75FA2DAC2038652B86","pay_type_320":0,"sid":282456,"bitrate":128,"time":165984,"pkg_price_flac":0,"pay_type_flac":0,"fail_process_flac":0,"filesize_flac":18483036,"ext":"mp3","privilege_128":0,"pkg_price_128":0,"privilege_flac":0,"price_320":0,"privilege_320":0,"hash":"D5D6C5C850776937E41221A495CA5AB0","mvhash":"9b624a23de9d2131b15e0cb6f12d7c76","price_flac":0,"album_id":"","vip":0,"320hash":"72BE3E30EB6D16908D49A27ADE8DBAEE","price_128":0,"m4asize":0,"320time":166032,"size":2656097,"fail_process_320":0,"size_ape":16665259,"m4ahash":"","bitrate_flac":0,"pay_type_128":0,"bitrate_ape":0,"hash_flac":"B6579CD35490F8F32B37C86DA48E2E91","fail_process_128":0,"pkg_price_320":0,"topic_url":"","320isfilehead":100,"name":"é\u0099\u0088ä¸\u0080ç\u008e² - ç\u0088±ä¹\u008bå\u0088\u009dä½\u0093éª\u008c(Live)","320size":6641280}],"description":"ä¸\u0080é¦\u0096ç\u009c\u009fæ­£å¥½å\u0090¬ç\u009a\u0084æ­\u008cé\u0099¤ä¸\u008dæ\u0096­è¢«ä¼ å\u0094±ä¹\u008bå¤\u0096ï¼\u008cç¿»å\u0094±ä¹\u009fæ\u0098¯å¸¸è§\u0081ç\u009a\u0084æ\u0096¹å¼\u008fä¹\u008bä¸\u0080ã\u0080\u0082æ\u0080»è\u0083½å\u0090¬å\u0088°ä¸\u008då\u0090\u008cæ­\u008cæ\u0089\u008bç\u009a\u0084å\u0085¨æ\u0096°æ¼\u0094ç»\u008eã\u0080\u0082ä¹\u009fè®¸å\u0094±å¾\u0097ä¸\u008då¦\u0082å\u008e\u009fç\u0089\u0088é\u0082£ä¹\u0088æ·±å\u0085¥ä½ å¿\u0083ï¼\u008cå\u008d´ä¹\u009fæ\u0098¯æ­\u008cæ\u0089\u008bä»¬ä¸ªäººå®\u009eå\u008a\u009bç\u009a\u0084æ\u009c\u0080å¥½ä½\u0093ç\u008e°ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"å\u008a²è\u0088\u009eå\u009b¢ç\u009a\u0084å\u009b\u009eå¿\u0086","fmid":"99","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20131120183506647742.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20131120183506176095.jpg","offset":242,"addtime":"2012-08-21 10:30:09","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"BDB2CD79964ADD60F2B357E3778B6B61","size_ape":23691945,"sid":464309,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"74d945f5186ed6c0726f8a22f6b8f307","price_128":0,"fail_process_320":12,"topic_url":"","size":3366242,"hash_ape":"C2F51710ED373C47F0E9A37C578C8D51","320size":8414754,"320hash":"CD02CB626190A8CBB86A3B66F747BC58","time":210390,"bitrate":128,"320isfilehead":100,"320time":210000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"ç½\u0097å¿\u0097ç¥¥ã\u0080\u0081å¾\u0090ç\u0086\u0099å¨£ - æ\u0081\u008bç\u0088±è¾¾äºº","pkg_price_128":0}],"description":"é»\u0091å¤\u009cé\u009c\u0093è\u0099¹ï¼\u008cæ\u008c\u0091é\u0080\u0097ç\u0081¯ç\u0081«ï¼\u008cå\u009c¨è·³å\u008a¨å¼ºå\u008a²ç\u009a\u0084è\u008a\u0082å¥\u008fä¸­æ\u0091\u0087æ\u009b³ã\u0080\u0082å\u008a²è\u0088\u009eå\u009b¢ï¼\u008cå\u009c¨è¿\u0099é\u0087\u008cï¼\u008cæ\u009c\u0089è\u0088\u009eè¹\u0088ï¼\u008cè¿\u0098æ\u009c\u0089ä¸\u0080å\u009cºé\u009f³ä¹\u0090ç\u009a\u0084ç\u009b\u009bå®´ï¼\u008cæ\u009c\u009få¾\u0085ä¸\u008eä½ ç\u009a\u0084é\u0082\u0082é\u0080\u0085ã\u0080\u0082"},{"heat":"26","isnew":"0","fmname":"å\u008a¨æ¼«","fmid":"8","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140320135556152997.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140320135518676024.jpg","offset":725,"addtime":"2011-09-01 18:46:39","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"hash_ape":"","pay_type_320":0,"sid":583310,"bitrate":128,"time":253000,"pkg_price_flac":0,"pay_type_flac":0,"fail_process_flac":0,"filesize_flac":0,"ext":"mp3","privilege_128":0,"pkg_price_128":0,"privilege_flac":0,"price_320":0,"privilege_320":0,"hash":"23E810D2A93DC47E91811EECF59FA281","mvhash":"","price_flac":0,"album_id":"","vip":0,"320hash":"E8F4A9FEE16DAEF93A5477C26FA57971","price_128":0,"m4asize":0,"320time":253000,"size":4055864,"fail_process_320":0,"size_ape":0,"m4ahash":"","bitrate_flac":0,"pay_type_128":0,"bitrate_ape":0,"hash_flac":"","fail_process_128":0,"pkg_price_320":0,"topic_url":"","320isfilehead":100,"name":"é«\u0098ç\u0094°æ\u0086\u0082å¸\u008cã\u0080\u0081å±±å\u008f£æ\u0084\u009b - Now Loading!!!!ã\u0080\u0090NEW GAME!ã\u0080\u0091","320size":10135554}],"description":"å\u009b ä¸ºä¸\u0080é\u0083¨ç\u009a\u0084å\u008a¨æ¼«ä½\u009cå\u0093\u0081å½»åº\u0095æ\u0094¹å\u008f\u0098æ\u0088\u0091ä»¬ç\u009a\u0084äººç\u0094\u009fè§\u0082ï¼\u008cä»\u008eæ­¤æ\u009c\u0089äº\u0086ç\u0094\u009få\u0091½ç\u009a\u0084è¿½æ±\u0082ã\u0080\u0082å\u008a¨æ¼«æ­\u008cæ\u009b²è®©æ\u0088\u0091ä»¬å\u0085\u0085æ»¡å\u008a\u009bé\u0087\u008fï¼\u008cå\u009c¨å¤±è\u0090½ä¸­æ\u0094¯æ\u0092\u0091ç\u009d\u0080æ\u0088\u0091ä»¬å\u008b\u0087æ\u0095¢å\u0089\u008dè¿\u009bï¼\u008cå\u009b ä¸ºå\u008a¨æ¼«è®©æ\u0088\u0091ä»¬å­¦ä¼\u009aä¸\u008dæ\u0094¾å¼\u0083ç\u009a\u0084å\u008b\u0087æ\u0095¢ç²¾ç¥\u009eã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"æ­¦ä¾ æ\u0083\u0085æ\u0080\u0080","fmid":"173","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140113190931200858.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140113190931402885.jpg","offset":166,"addtime":"2014-01-10 17:24:04","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"DC714E0CCD3CC94E1B54E7A572C38858","size_ape":0,"sid":255477,"pay_type_128":0,"m4asize":0,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"","price_128":0,"fail_process_320":0,"topic_url":"","size":3960478,"hash_ape":"","320size":9900538,"320hash":"39ED4F31062F50947D7469D2CDD386B4","time":247000,"bitrate":128,"320isfilehead":99,"320time":247000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"æ\u0088´å¨\u0086 - ç\u0088±æ\u0098¯ä»\u0099ä¸\u008aä»\u0099","pkg_price_128":0}],"description":"é\u0086\u0089é\u0085\u0092å½\u0093æ­\u008cäººç\u0094\u009få¦\u0082æ¢¦ï¼\u008cä¸\u0080èº«ç\u0099½è¡£ä¸\u0080æ\u008a\u008aæ\u008a\u0098æ\u0089\u0087é\u0097¯æ±\u009fæ¹\u0096ã\u0080\u0082å\u0088\u0080å\u0085\u0089å\u0089\u0091å½±ã\u0080\u0081å°\u0094è\u0099\u009eæ\u0088\u0091è¯\u0088ã\u0080\u0081ç\u0088±æ\u0081¨æ\u0083\u0085ä»\u0087ã\u0080\u0081è±ªæ\u0083\u0085ä¸\u0087ä¸\u0088ï¼\u008cå°½æ\u0098¾æ±\u009fæ¹\u0096æ\u009c¬è\u0089²ï¼\u008cé\u009a\u008fç\u009d\u0080é\u009f³ä¹\u0090å¸¦ä½ ç\u0095\u0085æ¸¸æ­¦ä¾ æ\u009f\u0094æ\u0083\u0085"},{"heat":"0","isnew":"0","fmname":"æµªæ¼«é\u009f©å\u0089§","fmid":"186","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20170103195624665198.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20170103195623897846.jpg","offset":36,"addtime":"2014-02-12 19:19:15","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"F1BB0FBFE227525E00CDE2DF74CD3D07","size_ape":0,"sid":613048,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"288DF790148E0B296B9A627CC00287F7","price_128":0,"fail_process_320":12,"topic_url":"","size":3773472,"hash_ape":"","320size":9433525,"320hash":"EE629EE546937E87ADE003C073F57EF3","time":235000,"bitrate":128,"320isfilehead":100,"320time":235000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"Mad Clownã\u0080\u0081é\u0087\u0091å¨\u009cè\u008b± - ë\u008b¤ì\u008b\u009c ë\u0084\u0088ë¥¼ã\u0080\u0090å¤ªé\u0098³ç\u009a\u0084å\u0090\u008eè£\u0094ã\u0080\u0091","pkg_price_128":0}],"description":"å\u0082¬æ³ªç\u009a\u0084é\u009f©å\u0089§æ\u0080\u008eä¹\u0088å°\u0091å¾\u0097äº\u0086æµªæ¼«å\u008a¨äººç\u009a\u0084æ\u0083\u0085æ­\u008cå\u0091¢ï¼\u009fè¿\u0099é\u0087\u008cä¸ºæ\u0082¨ç²¾é\u0080\u0089æ\u009c\u0080æµªæ¼«ç\u009a\u0084é\u009f©å\u0089§å\u008e\u009få£°å¸¦ï¼\u008cå¸¦ç»\u0099ä½ æ\u0097 é\u0099\u0090ç\u009a\u0084æ\u0084\u009få\u008a¨ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"åº\u0097é\u0093º","fmid":"175","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140115110327382020.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140115110327979971.jpg","offset":1040,"addtime":"2014-01-13 19:05:30","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"A5A2399855A5807077839A0C22237DBE","size_ape":26268405,"sid":412389,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":3239103,"hash_ape":"B681072701E95A4166100D82411B557B","320size":8099004,"320hash":"6EB7CA0809FD13B69D5F85B5AED6A6E0","time":202423,"bitrate":128,"320isfilehead":100,"320time":202476,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"sistar - up and down","pkg_price_128":0}],"description":"è¡\u0097å¤´å··å°¾ç\u009a\u0084æ\u0097¶é«¦åº\u0097é\u0093ºé\u0087\u008cæ\u0092­æ\u0094¾ç\u009a\u0084é\u009f³ä¹\u0090ï¼\u008cè\u0097\u008fç\u009d\u0080ä¸\u008då°\u0091ç§\u0098å¯\u0086ã\u0080\u0082ä¸\u0080æ\u0097¦é¡¾å®¢æ\u0084¿æ\u0084\u008få\u0081\u009cç\u0095\u0099ä¸\u008bæ\u009d¥ï¼\u008cé\u0082£ä¹\u0088ï¼\u008cæ¶\u0088è´¹ç\u009a\u0084æ\u009cºä¼\u009aå°±æ\u0097 å¤\u0084ä¸\u008då\u009c¨ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"ç»\u008få\u0085¸ç\u0094µè§\u0086å\u0089§å\u009b\u009eå¿\u0086","fmid":"782","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20160622175922680041.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20160622175921983298.jpg","offset":14,"addtime":"2016-06-22 17:59:23","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"7F3C4F1502FDA003F845ABA1828EBCD8","size_ape":23239680,"sid":529911,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"9AA01061D9B2364022D48BF111FCE51A","price_128":0,"fail_process_320":12,"topic_url":"","size":2731912,"hash_ape":"0C960018CC899106B4605A62FFCF0BD2","320size":6830698,"320hash":"D129D53692D62B12A4BA070BE74A0A96","time":170000,"bitrate":128,"320isfilehead":100,"320time":170737,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"ç\u008e\u008bå¿\u0083å\u0087\u008c - å½©è\u0099¹ç\u009a\u0084å¾®ç¬\u0091ã\u0080\u0090å¾®ç¬\u0091Pastaã\u0080\u0091","pkg_price_128":0}],"description":"å¸¦ä½ é\u0087\u008dæ¸©é\u0082£äº\u009bå¹´è¿½è¿\u0087ç\u009a\u0084ç»\u008få\u0085¸ç\u0094µè§\u0086å\u0089§ã\u0080\u0082"},{"heat":"0","isnew":"0","fmname":"é\u0082£å¹´MP3é\u0087\u008cç\u009a\u0084æ­\u008c","fmid":"693","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20160322114546452842.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20160322114546765348.jpg","offset":336,"addtime":"2016-03-21 11:56:49","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"068BCD1A773F02BC387E45B7E8EF348B","size_ape":31158948,"sid":593986,"pay_type_128":0,"m4asize":0,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"","price_128":0,"fail_process_320":0,"topic_url":"","size":4024047,"hash_ape":"EDC9F6724C7CBCA3AB89E4193CA96372","320size":10087553,"320hash":"2AF0059B3C1BB6CFA1D321B11F599BAF","time":251429,"bitrate":128,"320isfilehead":99,"320time":252000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"ç\u0088±ä¹\u0090å\u009b¢ - æ\u0094¾å¼\u0080","pkg_price_128":0}],"description":"è¿\u0098è®°å¾\u0097é\u0082£äº\u009bå¹´å\u0090¬è¿\u0087ç\u009a\u0084æ\u0083\u0085æ­\u008cå\u0090\u0097ï¼\u009få½\u0093æ\u0097¶å\u009c¨å\u0090¬é\u0082£é¦\u0096æ­\u008cç\u009a\u0084ä½ æ\u0098¯ä»\u0080ä¹\u0088æ ·ç\u009a\u0084å¿\u0083æ\u0083\u0085å\u0091¢ï¼\u009få²\u0081æ\u009c\u0088å¦\u0082æ¢­ï¼\u008cä¸\u008dç\u009f¥é\u0081\u0093å½\u0093ä½ å\u0086\u008dæ¬¡å\u0090¬èµ·ï¼\u008cå\u008f\u0088ä¼\u009aæ\u0098¯ä¸\u0080ç§\u008dä»\u0080ä¹\u0088æ ·ç\u009a\u0084æ\u0084\u009fè§\u0089å\u0091¢ï¼\u009f"},{"heat":"0","isnew":"0","fmname":"å\u008f\u0091ç\u0083§å¥³å£°","fmid":"692","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20160317104117292034.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20160317104117783175.jpg","offset":244,"addtime":"2016-03-17 10:41:18","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"50C51A74086ABAA6194C92C619FB9EEE","size_ape":27529304,"sid":479824,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":4251106,"hash_ape":"46455291F3E2DC0FEA282FD06F4A9710","320size":10615295,"320hash":"A9CA7CA5237201478E21E7FCE22E9A87","time":265430,"bitrate":128,"320isfilehead":100,"320time":265352,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"ç¢§å¨\u009c - ä½ å\u0088«æ\u0080ªæ\u0088\u0091","pkg_price_128":0}],"description":"å\u008f\u0091ç\u0083§å¥³å£°"},{"heat":"0","isnew":"0","fmname":"æ\u0083\u0085æ­\u008cå¯¹å\u0094±","fmid":"61","imgurl":"http://imge.kugou.com/fmlogov2/{size}/20140219023945158893.jpg","fmtype":2,"classid":"7","imgurl_size":"480,400,240,150","banner":"http://imge.kugou.com/fmbanner/{size}/20140219023944721090.jpg","offset":544,"addtime":"2012-01-06 16:06:59","classname":"ä¸»é¢\u0098","banner_size":"480,400,240,150","parentId":"0","songlist":[{"price_320":0,"pay_type_320":0,"privilege_320":0,"hash":"6F5931B6060107EBBFA3F8670015963B","size_ape":0,"sid":354263,"pay_type_128":0,"m4asize":0,"pkg_price_320":0,"privilege_128":0,"vip":0,"mvhash":"672dfa59e842c1dddc35e14fef7b5321","price_128":0,"fail_process_320":0,"topic_url":"","size":3138454,"hash_ape":"","320size":7847321,"320hash":"3C55E5D460C6596C4A24DFB67CE5DF32","time":196154,"bitrate":128,"320isfilehead":99,"320time":196000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"å\u0088\u0098ä¸¹è\u0090\u008cã\u0080\u0081å¾\u0090è\u0089¯ - å¤©å \u0082å²\u009bä¹\u0090å\u009b­","pkg_price_128":0}],"description":"â\u0080\u009cç\u0088±â\u0080\u009dæ\u0098¯ä¸\u0080ä¸ªæ°¸æ\u0081\u0092ä¸\u008då\u008f\u0098ç\u009a\u0084ä¸»é¢\u0098ã\u0080\u0082è\u0080\u008cå°\u0086ç\u0088±æ\u0083\u0085ç\u009a\u0084ä¸»è§\u0092ä»£å\u0085¥å\u0085¶ä¸­ç\u009a\u0084ç\u0094·å¥³å¯¹å\u0094±ï¼\u008cå\u0088\u0099ç\u0090\u0086æ\u0089\u0080å½\u0093ç\u0084¶æ\u0088\u0090ä¸ºäº\u0086è¯ é\u0087\u008aâ\u0080\u009cç\u0088±â\u0080\u009dç\u009a\u0084æ\u009c\u0080ä½³é\u0080\u0094å¾\u0084ã\u0080\u0082"}]
     * error_code : 0
     * class_count : 20
     */

    private int status;
    private int error_code;
    private int class_count;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getClass_count() {
        return class_count;
    }

    public void setClass_count(int class_count) {
        this.class_count = class_count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * heat : 0
         * isnew : 0
         * fmname : ä¸ççº§ç­é¨åæ²
         * fmid : 839
         * imgurl : http://imge.kugou.com/fmlogov2/{size}/20160929155356250137.jpg
         * fmtype : 2
         * classid : 7
         * imgurl_size : 480,400,240,150
         * banner : http://imge.kugou.com/fmbanner/{size}/20160929155355609701.jpg
         * offset : 528
         * addtime : 2016-09-21 14:45:09
         * classname : ä¸»é¢
         * banner_size : 480,400,240,150
         * parentId : 0
         * songlist : [{"price_320":200,"pay_type_320":3,"privilege_320":10,"hash":"18A8B9C8153D6213A0CA261A56273091","size_ape":0,"sid":609034,"pay_type_128":0,"m4asize":0,"pkg_price_320":1,"privilege_128":8,"vip":0,"mvhash":"","price_128":0,"fail_process_320":12,"topic_url":"","size":3480763,"hash_ape":"","320size":8699820,"320hash":"1FC0B40C1F625DC48EF7121395F7B09E","time":217000,"bitrate":128,"320isfilehead":100,"320time":217000,"fail_process_128":0,"ext":"mp3","album_id":"","m4ahash":"","name":"Jason Derulo - Trumpets","pkg_price_128":0}]
         * description : æ²¡å¬è¿ä½ å°±OUTäºã
         */

        private String heat;
        private String isnew;
        private String fmname;
        private String fmid;
        private String imgurl;
        private int fmtype;
        private String classid;
        private String imgurl_size;
        private String banner;
        private int offset;
        private String addtime;
        private String classname;
        private String banner_size;
        private String parentId;
        private String description;
        private List<SonglistBean> songlist;

        public String getHeat() {
            return heat;
        }

        public void setHeat(String heat) {
            this.heat = heat;
        }

        public String getIsnew() {
            return isnew;
        }

        public void setIsnew(String isnew) {
            this.isnew = isnew;
        }

        public String getFmname() {
            return fmname;
        }

        public void setFmname(String fmname) {
            this.fmname = fmname;
        }

        public String getFmid() {
            return fmid;
        }

        public void setFmid(String fmid) {
            this.fmid = fmid;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public int getFmtype() {
            return fmtype;
        }

        public void setFmtype(int fmtype) {
            this.fmtype = fmtype;
        }

        public String getClassid() {
            return classid;
        }

        public void setClassid(String classid) {
            this.classid = classid;
        }

        public String getImgurl_size() {
            return imgurl_size;
        }

        public void setImgurl_size(String imgurl_size) {
            this.imgurl_size = imgurl_size;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String getBanner_size() {
            return banner_size;
        }

        public void setBanner_size(String banner_size) {
            this.banner_size = banner_size;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<SonglistBean> getSonglist() {
            return songlist;
        }

        public void setSonglist(List<SonglistBean> songlist) {
            this.songlist = songlist;
        }

        public static class SonglistBean {
            /**
             * price_320 : 200
             * pay_type_320 : 3
             * privilege_320 : 10
             * hash : 18A8B9C8153D6213A0CA261A56273091
             * size_ape : 0
             * sid : 609034
             * pay_type_128 : 0
             * m4asize : 0
             * pkg_price_320 : 1
             * privilege_128 : 8
             * vip : 0
             * mvhash :
             * price_128 : 0
             * fail_process_320 : 12
             * topic_url :
             * size : 3480763
             * hash_ape :
             * 320size : 8699820
             * 320hash : 1FC0B40C1F625DC48EF7121395F7B09E
             * time : 217000
             * bitrate : 128
             * 320isfilehead : 100
             * 320time : 217000
             * fail_process_128 : 0
             * ext : mp3
             * album_id :
             * m4ahash :
             * name : Jason Derulo - Trumpets
             * pkg_price_128 : 0
             */

            private int price_320;
            private int pay_type_320;
            private int privilege_320;
            private String hash;
            private int size_ape;
            private int sid;
            private int pay_type_128;
            private int m4asize;
            private int pkg_price_320;
            private int privilege_128;
            private int vip;
            private String mvhash;
            private int price_128;
            private int fail_process_320;
            private String topic_url;
            private int size;
            private String hash_ape;
            @SerializedName("320size")
            private int value320size;
            @SerializedName("320hash")
            private String value320hash;
            private int time;
            private int bitrate;
            @SerializedName("320isfilehead")
            private int value320isfilehead;
            @SerializedName("320time")
            private int value320time;
            private int fail_process_128;
            private String ext;
            private String album_id;
            private String m4ahash;
            private String name;
            private int pkg_price_128;

            public int getPrice_320() {
                return price_320;
            }

            public void setPrice_320(int price_320) {
                this.price_320 = price_320;
            }

            public int getPay_type_320() {
                return pay_type_320;
            }

            public void setPay_type_320(int pay_type_320) {
                this.pay_type_320 = pay_type_320;
            }

            public int getPrivilege_320() {
                return privilege_320;
            }

            public void setPrivilege_320(int privilege_320) {
                this.privilege_320 = privilege_320;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public int getSize_ape() {
                return size_ape;
            }

            public void setSize_ape(int size_ape) {
                this.size_ape = size_ape;
            }

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getPay_type_128() {
                return pay_type_128;
            }

            public void setPay_type_128(int pay_type_128) {
                this.pay_type_128 = pay_type_128;
            }

            public int getM4asize() {
                return m4asize;
            }

            public void setM4asize(int m4asize) {
                this.m4asize = m4asize;
            }

            public int getPkg_price_320() {
                return pkg_price_320;
            }

            public void setPkg_price_320(int pkg_price_320) {
                this.pkg_price_320 = pkg_price_320;
            }

            public int getPrivilege_128() {
                return privilege_128;
            }

            public void setPrivilege_128(int privilege_128) {
                this.privilege_128 = privilege_128;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public String getMvhash() {
                return mvhash;
            }

            public void setMvhash(String mvhash) {
                this.mvhash = mvhash;
            }

            public int getPrice_128() {
                return price_128;
            }

            public void setPrice_128(int price_128) {
                this.price_128 = price_128;
            }

            public int getFail_process_320() {
                return fail_process_320;
            }

            public void setFail_process_320(int fail_process_320) {
                this.fail_process_320 = fail_process_320;
            }

            public String getTopic_url() {
                return topic_url;
            }

            public void setTopic_url(String topic_url) {
                this.topic_url = topic_url;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getHash_ape() {
                return hash_ape;
            }

            public void setHash_ape(String hash_ape) {
                this.hash_ape = hash_ape;
            }

            public int getValue320size() {
                return value320size;
            }

            public void setValue320size(int value320size) {
                this.value320size = value320size;
            }

            public String getValue320hash() {
                return value320hash;
            }

            public void setValue320hash(String value320hash) {
                this.value320hash = value320hash;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getValue320isfilehead() {
                return value320isfilehead;
            }

            public void setValue320isfilehead(int value320isfilehead) {
                this.value320isfilehead = value320isfilehead;
            }

            public int getValue320time() {
                return value320time;
            }

            public void setValue320time(int value320time) {
                this.value320time = value320time;
            }

            public int getFail_process_128() {
                return fail_process_128;
            }

            public void setFail_process_128(int fail_process_128) {
                this.fail_process_128 = fail_process_128;
            }

            public String getExt() {
                return ext;
            }

            public void setExt(String ext) {
                this.ext = ext;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getM4ahash() {
                return m4ahash;
            }

            public void setM4ahash(String m4ahash) {
                this.m4ahash = m4ahash;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPkg_price_128() {
                return pkg_price_128;
            }

            public void setPkg_price_128(int pkg_price_128) {
                this.pkg_price_128 = pkg_price_128;
            }
        }
    }
}
