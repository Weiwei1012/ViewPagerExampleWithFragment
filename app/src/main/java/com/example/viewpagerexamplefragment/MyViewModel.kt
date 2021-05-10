package com.example.viewpagerexamplefragment

import androidx.lifecycle.ViewModel

//store all scene data
class MyViewModel : ViewModel() {
    val sceneList = ArrayList<Scenes>() //list of scene data
    var cityList: List<String>  // list of city names

    init {  //initiate the photo list
        sceneList.add(
            Scenes(
                0,"Hualien",
                "長春祠",
                R.drawable.photo1_0,
                "為紀念開闢中橫公路殉職人員所建，祠旁湧泉長年流水成散瀑，公路局取名為「長春飛瀑」，成為中橫公路具特殊意義的地標。"
            )
        )
        sceneList.add(
            Scenes(
                1,"Hualien",
                "燕子口",
                R.drawable.photo1_1,
                "燕子口步道從燕子口到靳珩橋，途中可欣賞太魯閣峽谷、壺穴、湧泉、印地安酋長岩等景觀。"
            )
        )
        sceneList.add(
            Scenes(
                2,"Hualien",
                "慈母橋",
                R.drawable.photo1_2,
                "慈母橋是一座形狀美麗的紅色大橋，位於天祥以東三公里處的中橫公路上，為立霧溪與其支流荖西溪的匯流處。"
            )
        )
        sceneList.add(Scenes(3,"Taipei", "天元宮", R.drawable.photo0_0, "擁有五層圓型寶塔的壯觀寺廟，每逢櫻花季會吸引大批人潮。"))
        sceneList.add(
            Scenes(
                4,"Taipei",
                "Taipei101",
                R.drawable.photo0_1,
                "台北101是超高大樓，是綠建築，是購物中心，是觀景台，更是台灣的指標。"
            )
        )
        sceneList.add(
            Scenes(
                5,"Pintong",
                "墾丁",
                R.drawable.photo2_0,
                "墾丁國家公園是台灣在戰後時期第一個成立的國家公園，成立於1982年。"
            )
        )
        sceneList.add(
            Scenes(
                6,"Pintong",
                "龍磐公園",
                R.drawable.photo2_1,
                "未經開發的公園，於開闊的草坪中設有荒野小徑，並坐擁一望無際的海岸風光。"
            )
        )
    }

    init {
        //get the set of city names (remove redundant names)
        val tempSet = mutableSetOf<String>()  //empty set
        sceneList.forEach { tempSet.add(it.city) }
        cityList = tempSet.toList()  //convert the set into a list
    }
}