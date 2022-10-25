package com.example.myquizapp

object Constants {
    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val ques1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.afg,"Afghanistan","Turkey","UAE",
            "Kuwait",1
        )
        questionList.add(ques1)
        val ques2 = Question(
            1, "What country does this flag belong to?",
            R.drawable.aus,"United States","United Kingdom","New Zealand",
            "Australia",4
        )
        questionList.add(ques2)
        val ques3 = Question(
            1, "What country does this flag belong to?",
            R.drawable.finland,"Finland","Turkey","UAE",
            "Kuwait",1
        )
        questionList.add(ques3)
        val ques4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ind,"Ireland","India","UAE",
            "Kuwait",2
        )
        questionList.add(ques4)
        val ques5 = Question(
            1, "What country does this flag belong to?",
            R.drawable.jap,"Nepal","Turkey","Japan",
            "China",3
        )
        questionList.add(ques5)
        val ques6 = Question(
            1, "What country does this flag belong to?",
            R.drawable.nz,"United States","United Kingdom","New Zealand",
            "Australia",3
        )
        questionList.add(ques6)
        val ques7 = Question(
            1, "What country does this flag belong to?",
            R.drawable.sa,"South Africa","Turkey","UAE",
            "Kuwait",1
        )
        questionList.add(ques7)
        val ques8 = Question(
            1, "What country does this flag belong to?",
            R.drawable.sl,"Afghanistan","Turkey","Kazakhstan",
            "Sri Lanka",4
        )
        questionList.add(ques8)
        val ques9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.uk,"United States","United Kingdom","New Zealand",
            "Australia",2
        )
        questionList.add(ques9)
        val ques10 = Question(
            1, "What country does this flag belong to?",
            R.drawable.us,"United States","United Kingdom","New Zealand",
            "Australia",1
        )
        questionList.add(ques10)


        return questionList
    }
}