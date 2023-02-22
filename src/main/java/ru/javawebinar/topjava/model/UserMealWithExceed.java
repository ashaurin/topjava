package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

public class UserMealWithExceed {
        protected Integer id;

        protected final LocalDateTime dateTime;

        protected final String description;

        protected final Boolean exceed;

        private final int calories;

        public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, int calories, boolean exceed) {
            this.id = id;
            this.dateTime = dateTime;
            this.description = description;
            this.calories = calories;
            this.exceed = exceed;
        }

    public UserMealWithExceed(String description, Boolean exceed, int calories, LocalDateTime dateTime) {
        this.description = description;
        this.exceed = exceed;
        this.calories = calories;
        this.dateTime = dateTime;
        this.id = null;
    }

    public LocalDateTime getDateTime() { return dateTime; }

        public String getDescription() { return description; }

        public int getCalories() { return calories; }

        public boolean isNew() {return id == null; }

        public void setId(int id) {this.id = id; }

        public Integer getId() {return id; }

        @Override
        public String toString() {
            return "MealTo{" +
                    "dateTime=" + dateTime +
                    ", description='" + description + '\'' +
                    ", calories=" + calories +
                    '}';
        }
    }

