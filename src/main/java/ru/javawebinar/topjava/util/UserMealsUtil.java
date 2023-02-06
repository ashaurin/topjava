package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));

        System.out.println(filteredByStreams2(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
        Map<LocalDate,Integer> map = new HashMap<>();

        meals.forEach(userMeal ->
                map.merge(userMeal.getDateTime().toLocalDate(), userMeal.getCalories(), Integer::sum)
        );

        List<UserMealWithExcess> list = new ArrayList<>();

        meals.forEach(userMeal -> {
            LocalTime time = userMeal.getDateTime().toLocalTime();
            if (time.equals(startTime) || (time.isAfter(startTime)) && (time.isBefore(endTime)))
                list.add(new UserMealWithExcess(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), map.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay));
        });
        return list;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        System.out.println("TODO Implement by streams");

        Map<LocalDate,Integer> map = new HashMap<>();

        meals.forEach(userMeal ->
                map.merge(userMeal.getDateTime().toLocalDate(), userMeal.getCalories(), Integer::sum)
        );

        List<UserMealWithExcess> list = new ArrayList<>();

        meals
                .stream()
                .filter(userMeal -> {
                    LocalTime time = userMeal.getDateTime().toLocalTime();
                    return time.equals(startTime) || (time.isAfter(startTime)) && (time.isBefore(endTime));
                })
                .forEach(userMeal -> list.add(new UserMealWithExcess(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), map.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay))
                );

        return list;
    }

    public static List<UserMealWithExcess> filteredByStreams2(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        System.out.println("TODO Implement by streams");

        HashMap<LocalDate,Integer> map = new HashMap<>();

        meals.forEach(userMeal ->
                map.merge(userMeal.getDateTime().toLocalDate(), userMeal.getCalories(), Integer::sum)
        );

        List<UserMealWithExcess> list = new ArrayList<>();

        meals
                .stream()
                .filter(userMeal -> {
                    LocalTime time = userMeal.getDateTime().toLocalTime();
                    return time.equals(startTime) || (time.isAfter(startTime)) && (time.isBefore(endTime));
                })
                .forEach(userMeal -> list.add(new UserMealWithExcess(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), map.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay))
                );

        return list;
    }

}
/*
Внутри метода filteredByCycles надо сначала посчитать сумму калорий на каждую дату,
которая есть в коллекции meals и сохранить это в новую коллекцию, например использовать HashMap,
где ключем будет дата, а значением сумма калорий за день.
Далее еще раз пройтись по всем значениям meals и взять те записи, которые есть в нужном диапазоне даты и времени
и прибавить значение excess, которое мы можем получить из сравнения ранее полученного значения суммы калорий и аргумента caloriesPerDay
 */