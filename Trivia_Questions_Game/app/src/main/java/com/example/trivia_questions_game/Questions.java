package com.example.trivia_questions_game;

public class Questions {
    public Question[] questions = new Question[10];

//    public Questions(Question[] questions) {
//        this.questions = questions;
//    }

    public Questions() {
        questions[0] = new Question("מי מבין האנשים הבאים לא היה נשיא מדינת ישראל?",
                new String[]{"לוי אשכול", "עזר ויצמן", "אפרים קציר", "יצחק בן-צבי"},
                "לוי אשכול");
        questions[1] = new Question("מי מבין האנשים הבאים לא היה נשיא ארה\"ב?",
                new String[]{"בנג'מין פרנקלין", "ג'ון אדמס", "אברהם ליקולן", "דוויט אייזנהאואר"},
                "בנג'מין פרנקלין");
        questions[2] = new Question("איזה מהסרטים הבאים אינו של דיסני?",
                new String[]{"היפהפייה והיחפן", "שלגיה ושבעת הגמדים", "ספר הג'ונגל", "צעצוע של סיפור"},
                "צעצוע של סיפור");
        questions[3] = new Question("באיזו שנה הסתיימה מלחמת העולם השנייה?",
                new String[]{"1943", "1941", "1945", "1939"},
                "1945");
        questions[4] = new Question("כמה מדליות אולימפיות יש לישראל?",
                new String[]{"7", "12", "9", "3"},
                "9");
        questions[5] = new Question("באיזו שנה סיימו לבנות את מגדל אייפל בפריז?",
                new String[]{"1930", "1842", "1889", "1905"},
                "The Democrats");
        questions[6] = new Question("מהו שיא העולם בריצת מאה מטר(בשניות)?",
                new String[]{"9.58", "9.84", "9.25", "9.42"},
                "9.58");
        questions[7] = new Question("באיזה שנה התרחש פיגוע מגדלי התאומים?",
                new String[]{"2000", "2001", "2002", "2003"},
                "2001");
        questions[8] = new Question("איפה נולד ארנולד שוורצנגר?",
                new String[]{"אוסטריה", "גרמניה", "לפלמד", "קנדה"},
                "אוסטריה");
        questions[9] = new Question("באיזה סרט בראד פיט לא השתתף?",
                new String[]{"שבעה חטאים", "מועדון קרב", "אמירקן ביוטי", "תלמה ולאויז"},
                "אמירקן ביוטי");
    }

    public Question getQuestion(int index) {
        return questions[index];
    }

}
