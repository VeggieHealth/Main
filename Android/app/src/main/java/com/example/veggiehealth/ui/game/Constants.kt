package com.example.veggiehealth.ui.game

import com.example.veggiehealth.R

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    private var currentQuestionIndex: Int = 0

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "What vegetable is this?",
            R.drawable.veggie_kacangpolong,
            "Kacang Polong", "Kol",
            "Tomat", "Kubis", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What vegetable is this?",
            R.drawable.veggie_pare,
            "Terong Bulat", "Kangkung",
            "Pare", "Sawi", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What vegetable is this?",
            R.drawable.veggie_labuair,
            "Paprika", "Brokoli",
            "Kembang Kol", "Labu Air", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What vegetable is this?",
            R.drawable.veggie_terongbulat,
            "Labu Air", "Terong Bulat",
            "Kacang Polong", "pare", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What vegetable is this?",
            R.drawable.veggie_brokoli,
            "kentang", "timun",
            "Brokoli", "Terong", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What vegetable is this?",
            R.drawable.veggie_kubis,
            "Kubis/Kol", "Tomat",
            "Terong", "Kangkung", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What vegetable is this?",
            R.drawable.veggie_paprika,
            "Tomat", "Kangkung",
            "Paprika", "Wortel", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What vegetable is this?",
            R.drawable.veggie_wortel,
            "Ubi", "Kembang Kol",
            "Kentang", "Wortel", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What vegetable is this?",
            R.drawable.veggie_kembangkol,
            "Paprika", "Kembang Kol",
            "Kentang", "Timun", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What vegetable is this?",
            R.drawable.veggie_timun,
            "Timun", "Kacang Polong",
            "Terong", "pepaya muda", 1
        )

        questionsList.add(que10)

        // 11
        val que11 = Question(
            11, "What vegetable is this?",
            R.drawable.veggie_pepayamuda,
            "pepayamuda", "Kol",
            "Tomat", "Kubis", 1
        )

        questionsList.add(que11)

        // 12
        val que12 = Question(
            12, "What vegetable is this?",
            R.drawable.veggie_kentang,
            "kangkung", "terong",
            "kentang", "Sawi", 3
        )

        questionsList.add(que12)

        // 13
        val que13 = Question(
            13, "What vegetable is this?",
            R.drawable.veggie_labukuning,
            "Paprika", "labu air",
            "Kol", "Labu kuning", 4
        )

        questionsList.add(que13)

        // 14
        val que14 = Question(
            14, "What vegetable is this?",
            R.drawable.veggie_lobak,
            "Labu Kuning", "Lobak",
            "Kacang Panjang", "pare", 2
        )

        questionsList.add(que14)

        // 15
        val que15 = Question(
            15, "What vegetable is this?",
            R.drawable.veggie_tomato,
            "wortel", "lobak",
            "tomat", "Brokoli", 3
        )

        questionsList.add(que15)

        // 16
        val que16 = Question(
            16, "What vegetable is this?",
            R.drawable.veggie_buncis,
            "Buncis", "Jagung",
            "Kentang", "Kangkung", 1
        )

        questionsList.add(que16)

        // 17
        val que17 = Question(
            17, "What vegetable is this?",
            R.drawable.veggie_daunsingkong,
            "Daun Pisang", "Daun Pepaya",
            "Daun Singkong", "Daun Mangga", 3
        )

        questionsList.add(que17)

        // 18
        val que18 = Question(
            18, "What vegetable is this?",
            R.drawable.veggie_tauge,
            "Lobak", "Kembang Kol",
            "wortel", "Tauge", 4
        )

        questionsList.add(que18)

        // 19
        val que19 = Question(
            19, "What vegetable is this?",
            R.drawable.veggie_melinjo,
            "Kangkung", "Melinjo",
            "Sawi", "Wortel", 2
        )

        questionsList.add(que19)

        return questionsList
    }
    fun resetGame() {

        currentQuestionIndex = 0
    }


}