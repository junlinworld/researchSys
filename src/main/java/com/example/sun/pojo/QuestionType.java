package com.example.sun.pojo;

public enum QuestionType {

    Fill("填空题", 3), Multiple("多选题", 2), Choose("单选题", 1);


    private String type;
    private int flag;

    QuestionType(String str, int i) {
        this.type = str;
        this.flag = i;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public static QuestionType getQuestionTypeByFlag(int i) {
//        for (QuestionType type:QuestionType.values()){
//            if (type.getFlag() == i){
//                return type;
//            }
//        }

        for (QuestionType type : QuestionType.values()) {
            if (type.getFlag() == i) {
                return type;
            }
        }

        return null;
    }


    public static QuestionType getQuestionTypeByName(String name) {
//        for (QuestionType type:QuestionType.values()){
//            if (type.getType().equals(name)){
//                return type;
//            }
//        }

        for (QuestionType type : QuestionType.values()) {
            if (type.getType().equals(name)) {
                return type;
            }
        }

        return null;
    }
}
