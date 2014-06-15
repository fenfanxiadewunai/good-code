package com.huang.builder;


public class ConditionObject {

    private ConditionObject() {
    }

    public static Builder builder() {
        return new Builder();
    }

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {

        private int id;
        private String name;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String name) {
            this.name = name;
            return this;
        }

        public ConditionObject build() {
            ConditionObject condition = new ConditionObject();
            condition.id = this.id;
            condition.name = this.name;
            return condition;
        }
    }

}
