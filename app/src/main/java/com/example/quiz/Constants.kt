package com.example.quiz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_answers"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Questions> {

        val questionList = ArrayList<Questions>()

        val quest1 = Questions(
            1,
            "The flag of which country is this",
            R.drawable.afgflag,
            "USA",
            "Afghanistan",
            "Armenia",
            "Yemen",
            2
        )

        questionList.add(quest1)

        val quest2 = Questions(
            2,
            "The flag of which country is this",
            R.drawable.albflag,
            "Australia",
            "Bolivia",
            "Albania",
            "China",
            3
        )

        questionList.add(quest2)

        val quest3 = Questions(
            3,
            "The flag of which country is this",
            R.drawable.andflag,
            "Andorra",
            "Great Brittan",
            "Iraq",
            "Yemen",
            1
        )

        questionList.add(quest3)

        val quest4 = Questions(
            4,
            "The flag of which country is this",
            R.drawable.angflag,
            "Georgia",
            "Uruguay",
            "Angola",
            "Zimbabwe",
            3
        )

        questionList.add(quest4)

        val quest5 = Questions(
            5,
            "The flag of which country is this",
            R.drawable.argflag,
            "Mexico",
            "Iran",
            "Dominica",
            "Argentina",
            4
        )

        questionList.add(quest5)

        val quest6 = Questions(
            6,
            "The flag of which country is this",
            R.drawable.barflag,
            "Barbados",
            "Dominica",
            "Jamaica",
            "Australia",
            1
        )

        questionList.add(quest6)

        val quest7 = Questions(
            7,
            "The flag of which country is this",
            R.drawable.bocflag,
            "Barbados",
            "Dominica",
            "Jamaica",
            "Botswana",
            4
        )

        questionList.add(quest7)

        val quest8 = Questions(
            8,
            "The flag of which country is this",
            R.drawable.gbflag,
            "Denmark",
            "Barbados",
            "Great Brittan",
            "Austria",
            3
        )

        questionList.add(quest8)

        val quest9 = Questions(
            9,
            "Which is the capital city of Australia",
            R.drawable.canberra_mount,
            "Sidney",
            "Melbourne",
            "Adelaide",
            "Canberra",
            4
        )

        questionList.add(quest9)

        return questionList

    }

}