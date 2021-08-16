//package com.example.vaccinationmanagementsystem;
//
//import com.example.vaccinationmanagementsystem.enums.Disease;
//import com.example.vaccinationmanagementsystem.enums.Status;
//import com.example.vaccinationmanagementsystem.models.*;
//
//import java.time.LocalDate;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class App {
//    public static void main(String[] args) {
//
//        Map<Vaccine, Integer> map = new HashMap<>();
//        map.put(Vaccine.PFIZER, 2);
//        map.put(Vaccine.ASTRAZENECA, 1);
//        map.put(Vaccine.SINOVAC, 0);
//        map.put(Vaccine.MODERNA, 25);
//        map.put(Vaccine.SPUTNIK, 34);
//        VaccineInventory vaccineInventory = new VaccineInventory(map);
//
//        /*map.entrySet().forEach((entry) -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });*/
//
//        List<Citizen> citizenList = List.of(
//                new Citizen("1234567890", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.HIGH, LocalDate.of(1970, 6, 16), LocalDate.of(2021, 8, 14))
//                ,new Citizen("1234567890", "Darian", "Alfonso", "aasfsdsa"
//                         , Disease.HIGH, LocalDate.of(1970, 5, 16), LocalDate.of(2021, 8, 14))
//                , new Citizen("1234567891", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.LOW, LocalDate.of(1960, 6, 16), LocalDate.of(2021, 8, 11))
//                , new Citizen("1234567892", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.MID, LocalDate.of(1983, 6, 16), LocalDate.of(2021, 8, 13))
//                , new Citizen("1234567893", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.HIGH, LocalDate.of(1990, 6, 16), LocalDate.of(2021, 8, 12))
//                , new Citizen("1234567894", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.LOW, LocalDate.of(1991, 6, 16), LocalDate.of(2021, 8, 14))
//                , new Citizen("1234567894", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.HIGH, LocalDate.of(1996, 6, 16), LocalDate.of(2021, 8, 10))
//                , new Citizen("1234567895", "Darian", "Alfonso", "aasfsdsa"
//                        , Disease.HIGH, LocalDate.of(2001, 6, 16), LocalDate.of(2021, 8, 12)));
//
//        citizenList.forEach(citizen -> System.out.println(citizen));
//        System.out.println("******************************************************************************************");
//        App.priorityForAge(citizenList);
//        App.priorityForDisease(citizenList);
//        List<Citizen> listOrdered;
//        listOrdered = App.organizeCitizen(citizenList);
//        listOrdered.forEach(citizen -> System.out.println(citizen));
//
//        for (int i=0;i<listOrdered.size();i++){
//            App.givenVaccine(listOrdered.get(i),map);
//        }
//
//        map.entrySet().forEach((entry) -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//
//        listOrdered.forEach(citizen -> System.out.println(citizen));
//
//        /*System.out.println(Validations.isEcuadorianDocumentValid("1756876213"));
//        System.out.println(Validations.isUsernameValid("Darian8-Mica"));
//        System.out.println(Validations.isEmailValid("dmmalfonso@gmail.com"));
//        System.out.println(Validations.isNameOrLastValid("DarianM"));*/
//    }
//
//    public static void priorityForAge(List<Citizen> citizens) {
//        citizens.forEach(citizen -> {
//            Integer age = citizen.getAge(citizen);
//            if (age >= 18 && age <= 25) {
//                citizen.priority += 4;
//            }
//            if (age >= 26 && age <= 35) {
//                citizen.priority += 3;
//            }
//            if (age >= 36 && age <= 50) {
//                citizen.priority += 2;
//            }
//            if (age > 50) {
//                citizen.priority++;
//            }
//        });
//    }
//
//    public static void priorityForDisease(List<Citizen> citizens) {
//        citizens.forEach(citizen -> {
//            if (citizen.disease.equals(Disease.LOW)) {
//                citizen.priority += 3;
//            }
//            if (citizen.disease.equals(Disease.MID)) {
//                citizen.priority += 2;
//            }
//            if (citizen.disease.equals(Disease.HIGH)) {
//                citizen.priority += 1;
//            }
//        });
//    }
//
//    public static List<Citizen> organizeCitizen(List<Citizen> citizens) {
//
//        return citizens.stream()
//                .sorted(Comparator.comparing(Citizen::getRegistrationDate))
//                .sorted(Comparator.comparing(Citizen::getPriority))
//                .collect(Collectors.toList());
//    }
//
//    private static Citizen givenVaccine(Citizen citizen, Map<Vaccine,Integer>map) {
//        Integer temp;
//        if (citizen.getAge(citizen) > 50) {
//            temp = 0;
//            citizen.setVaccine(Vaccine.PFIZER);
//            if(map.containsKey(Vaccine.PFIZER) && map.get(Vaccine.PFIZER) > 0) {
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.PFIZER) - 1;
//                map.replace(Vaccine.PFIZER, map.get(Vaccine.PFIZER), temp);
//            }
//        }
//        if (citizen.getAge(citizen) >= 36 && citizen.getAge(citizen) <= 50) {
//            temp = 0;
//            if(map.containsKey(Vaccine.MODERNA) && map.get(Vaccine.MODERNA) > 0){
//                citizen.setVaccine(Vaccine.MODERNA);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.MODERNA) -1;
//                map.replace(Vaccine.MODERNA,map.get(Vaccine.MODERNA),temp);
//            } else if(map.containsKey(Vaccine.ASTRAZENECA) && map.get(Vaccine.ASTRAZENECA) > 0) {
//                citizen.setVaccine(Vaccine.ASTRAZENECA);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.ASTRAZENECA) - 1;
//                map.replace(Vaccine.ASTRAZENECA, map.get(Vaccine.ASTRAZENECA), temp);
//            }
//        }
//        if (citizen.getAge(citizen) >= 26 && citizen.getAge(citizen) <= 35) {
//            temp = 0;
//            if(map.containsKey(Vaccine.ASTRAZENECA) && map.get(Vaccine.ASTRAZENECA) > 0){
//                citizen.setVaccine(Vaccine.ASTRAZENECA);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.ASTRAZENECA) -1;
//                map.replace(Vaccine.ASTRAZENECA,map.get(Vaccine.ASTRAZENECA),temp);
//            } else if (map.containsKey(Vaccine.SINOVAC) && map.get(Vaccine.SINOVAC) > 0) {
//                citizen.setVaccine(Vaccine.SINOVAC);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.SINOVAC) - 1;
//                map.replace(Vaccine.SINOVAC, map.get(Vaccine.SINOVAC), temp);
//            }
//        }
//        if (citizen.getAge(citizen) >= 18 && citizen.getAge(citizen) <= 25) {
//            temp = 0;
//            if (map.containsKey(Vaccine.SPUTNIK) && map.get(Vaccine.SPUTNIK) > 0) {
//                citizen.setVaccine(Vaccine.SPUTNIK);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.SPUTNIK) - 1;
//                map.replace(Vaccine.SPUTNIK, map.get(Vaccine.SPUTNIK), temp);
//            } else if (map.containsKey(Vaccine.SINOVAC) && map.get(Vaccine.SINOVAC) > 0) {
//                citizen.setVaccine(Vaccine.SINOVAC);
//                citizen.setStatus(Status.SCHEDULED);
//                temp = map.get(Vaccine.SINOVAC) - 1;
//                map.replace(Vaccine.SINOVAC, map.get(Vaccine.SINOVAC), temp);
//            }
//        }
//        if(citizen.getStatus() != Status.SCHEDULED){
//            citizen.setStatus(Status.PENDING);
//        }
//        return citizen;
//    }
//
//
//
//}

