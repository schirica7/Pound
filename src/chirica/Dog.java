/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chirica;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This project was created for educational purposes. Copyright (c) 2022. All
 * rights reserved.
 *
 * @author Stefan Chirica
 */
public class Dog implements Serializable {

    //Fields
    private transient Pound pound; //Ignores this if you save it
    private String name;
    private String breed;
    private String furColor;
    private String gender;
    private ArrayList<String> description = new ArrayList<>();

    private int age; //in years
    private int aggressionLevel; //0 to 100; 100 means run away
    private int hungerLevel; //0 to 100; 100 means VERY hungry
    private int energyLevel; //0-100; 100 means FULL of energy

    private boolean isFixed;
    private boolean isTrained;

    private double height; //in inches
    private double weight; // in pounds

//    public Dog(Pound pound) {
//        this.pound = pound;
//        name = "Bella";
//        breed = "Mutt";
//        furColor = "Brown";
//        gender = "Female";
//        age = 0;
//        aggressionLevel = 50;
//        hungerLevel = 50;
//        energyLevel = 50;
//        isFixed = false;
//        isTrained = false;
//        isSitting = false;
//        isSleeping = false;
//        food = "nothing";
//        drink = "nothing";
//        toy = "nothing";
//        height = 6;
//        weight = 8.0;
//    }
    /**
     * Constructor receives two parameters and creates new dog Uses default
     * values for additional properties
     *
     * @param pound - Pound datatype for dog GUI
     * @param name - String datatype for dog name
     */
    public Dog(Pound pound, String name) {
        this.pound = pound;
        this.name = name;
        breed = "Mutt";
        furColor = "Brown";
        gender = "Female";
        age = 0;
        aggressionLevel = 50;
        hungerLevel = 50;
        energyLevel = 50;
        isFixed = false;
        isTrained = false;
        height = 6;
        weight = 8.0;
    }

//    public Dog(Pound pound, String name, String breed, String furColor,
//            String gender, int age, int aggressionLevel,
//            int hungerLevel, int energyLevel, boolean isFixed,
//            boolean isTrained, boolean isSitting, boolean isSleeping,
//            double height, double weight) {
//        this.pound = pound;
//        this.name = name;
//        this.breed = breed;
//        this.furColor = furColor;
//        this.gender = gender;
//        this.age = age;
//        this.aggressionLevel = aggressionLevel;
//        this.hungerLevel = hungerLevel;
//        this.energyLevel = energyLevel;
//        this.isFixed = isFixed;
//        this.isTrained = isTrained;
//        this.isSitting = isSitting;
//        this.isSleeping = isSleeping;
//        this.food = "nothing";
//        this.drink = "nothing";
//        this.toy = "nothing";
//        this.height = height;
//        this.weight = weight;
//    }
    /**
     * Getter method that returns dog's pound
     *
     * @return - Pound datatype for dog's pound
     */
    public Pound getPound() {
        return pound;
    }

    /**
     * Allows user to set the dog's pound to whatever they want
     *
     * @param pound - Pound datatype for dog GUI
     */
    public void setPound(Pound pound) {
        this.pound = pound;
    }

    /**
     * Getter method that returns dog's name
     *
     * @return String datatype for dog's name
     */
    public String getName() {
        return name;
    }

    /**
     * Allows user to set the dog's name to whatever they want
     *
     * @param name - string datatype for dog's name
     */
    public void setName(String name) {
        if (name.length() > 0 && name.charAt(0) != ' ') {
            this.name = name;
        }
    }

    /**
     * Getter method that returns dog's breed
     *
     * @return String datatype for dog's breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Allows user to set the dog's breed to whatever they want
     *
     * @param breed - string datatype for dog's breed
     */
    public void setBreed(String breed) {
        if (breed.length() > 0 && breed.charAt(0) != ' ') {
            this.breed = breed;
        }
    }

    /**
     * Getter method that returns dog's color
     *
     * @return String datatype for dog's color
     */
    public String getFurColor() {
        return furColor;
    }

    /**
     * Allows user to set the dog's fur color to whatever they want
     *
     * @param furColor - string datatype for dog's fur color
     */
    public void setFurColor(String furColor) {
        if (furColor.length() > 0 && furColor.charAt(0) != ' ') {
            this.furColor = furColor;
        }
    }

    /**
     * Getter method that returns dog's gender
     *
     * @return String datatype for dog's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Allows user to set the dog's gender to either male or female
     *
     * @param gender - string datatype for dog's gender
     */
    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female")
                || gender.equalsIgnoreCase("f")
                || gender.equalsIgnoreCase("girl")) {
            this.gender = "Female";
        } else {
            this.gender = "Male";
        }
    }

    /**
     * Getter method that returns dog's age
     *
     * @return int datatype for dog's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Allows user to set the dog's age to whatever they want between 0 and 30
     *
     * @param age - int datatype for dog's age
     */
    public void setAge(int age) {
        if (age >= 0) {
            if (age < 30) {
                this.age = age;
            } else {
                this.age = 30;
            }
        } else {
            this.age = 0;
        }
    }

    /**
     * Getter method that returns dog's aggression level
     *
     * @return int datatype for dog's aggression level
     */
    public int getAggressionLevel() {
        return aggressionLevel;
    }

    /**
     * Allows user to set the dog's aggression level to whatever they want
     * between 0 and 100
     *
     * @param aggressionLevel - int datatype for dog's aggression level
     */
    public void setAggressionLevel(int aggressionLevel) {
        if (aggressionLevel > 100) {
            this.aggressionLevel = 100;
        } else if (aggressionLevel >= 0) {
            this.aggressionLevel = aggressionLevel;
        } else {
            this.aggressionLevel = 0;
        }
    }

    /**
     * Getter method that returns dog's hunger level
     *
     * @return int datatype for dog's hunger level
     */
    public int getHungerLevel() {
        return hungerLevel;
    }

    /**
     * Allows user to set the dog's hunger level to whatever they want between 0
     * and 100
     *
     * @param hungerLevel - int datatype for dog's hungerLevel
     */
    public void setHungerLevel(int hungerLevel) {
        if (hungerLevel > 100) {
            this.hungerLevel = 100;
        } else if (hungerLevel >= 0) {
            this.hungerLevel = hungerLevel;
        } else {
            this.hungerLevel = 0;
        }
    }

    /**
     * Getter method that returns dog's fixed status
     *
     * @return boolean datatype for if dog is fixed
     */
    public boolean getIsFixed() {
        return isFixed;
    }

    /**
     * Allows users to update dog's fixed status
     *
     * @param isFixed - boolean datatype of what you want the dog's fixed status
     * to be
     */
    public void setIsFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }

    /**
     * Getter method that returns dog's trained status
     *
     * @return boolean datatype for if dog is trained
     */
    public boolean getIsTrained() {
        return isTrained;
    }

    /**
     * Allows users to update dog's trained status
     *
     * @param isTrained - boolean datatype of what you want the dog's trained
     * status to be
     */
    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }

    /**
     * Getter method that returns dog's height
     *
     * @return double datatype for dog's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Allows users to set dog's height to any number between 3 and 48 inches
     *
     * @param height - double value for dog's height in inches
     */
    public void setHeight(double height) {
        if (height > 48.0) {
            this.height = 48.0;
        } else if (height >= 3.0) {
            this.height = height;
        } else {
            this.height = 3.0;
        }
    }

    /**
     * Getter method that returns dog's weight
     *
     * @return double datatype for dog's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Allows users to set dog's weight to any number between 0.5 and 400 pounds
     *
     * @param weight - double value for dog's weight in pounds
     */
    public void setWeight(double weight) {
        if (weight > 400.0) {
            this.weight = 400.0;
        } else if (weight >= 0.5) {
            this.weight = weight;
        } else {
            this.weight = 0.5;
        }
    }

    /**
     * Getter method that returns dog's energy level
     *
     * @return int datatype for dog's energy level
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Allows user to set the dog's energy level to whatever they want between 0
     * and 100
     *
     * @param energyLevel - int datatype for dog's energy level
     */
    public void setEnergyLevel(int energyLevel) {
        if (energyLevel > 100) {
            this.energyLevel = 100;
        } else if (energyLevel >= 0) {
            this.energyLevel = energyLevel;
        } else {
            this.energyLevel = 0;
        }
    }

    /**
     * Getter method that returns dog description
     *
     * @return String ArrayList datatype for dog's description
     */
    public ArrayList<String> getDescription() {
        return description;
    }

    /**
     * Method that allows users to add something to the dog's description
     *
     * @param issue - String datatype of what is to be added to the description
     */
    public void addIssue(String issue) {
        description.add(issue);
    }

    /**
     * Method that allows users to remove something from the dog's description
     *
     * @param issue - String datatype of what is to be removed from the
     * description
     */
    public void removeIssue(String issue) {
        description.remove(issue);
    }

    /**
     * Makes a dog a string
     */
    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", breed=" + breed + ", furColor=" + furColor + ", gender=" + gender + ", age=" + age + ", aggressionLevel=" + aggressionLevel + ", hungerLevel=" + hungerLevel + ", isFixed=" + isFixed + ", isTrained=" + isTrained + ", height=" + height + ", weight=" + weight + '}';
    }

    /**
     * Displays dog's default picture
     */
    public void sit() {
        try {
            pound.changePicture("default");
            pound.updateStats();
            Thread.sleep(400);

        } catch (InterruptedException error) {
            System.err.println(error.getMessage());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }

    /**
     * Shows poop picture and updates energy and weight, then returns to default
     * picture
     */
    public void poop() {
        try {
            setEnergyLevel(energyLevel + 1);
            weight -= 0.10;
            pound.changePicture("poop");

            pound.updateStats();
            Thread.sleep(1000);
            pound.changePicture("default");
        } catch (InterruptedException error) {
            System.err.println(error.getMessage());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }

    /**
     * Shows pee picture and updates energy and weight, then returns to default
     * picture
     */
    public void pee() {
        try {
            setEnergyLevel(energyLevel + 1);
            weight -= 0.05;
            pound.changePicture("pee");

            pound.updateStats();
            Thread.sleep(1000);
            pound.changePicture("default");
        } catch (InterruptedException error) {
            System.err.println(error.getMessage());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }

    /**
     * Plays panting sound, and plays running animation for the amount of time
     * the dog runs
     *
     * Stats change accordingly while the dog is running
     *
     * @param howLong - int datatype for amount of time the dog runs
     */
    public void run(int howLong) {
        String soundName = "dog_pant.wav";

        try {
            AudioInputStream ais
                    = AudioSystem.getAudioInputStream(getClass().getResource(soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            ais.close();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

        if (energyLevel > 25) {
            for (int i = 0; i < howLong; i++) {
                try {
                    pound.changePicture("run1");
                    pound.updateStats();
                    Thread.sleep(150);

                    pound.changePicture("run2");
                    pound.updateStats();
                    Thread.sleep(150);

                    pound.changePicture("run3");
                    pound.updateStats();
                    Thread.sleep(150);

                    pound.changePicture("run2");
                    pound.updateStats();
                    Thread.sleep(150);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                setEnergyLevel(energyLevel - 1);
                setHungerLevel(hungerLevel + 2);
                setWeight(weight - 0.0001);

                if (energyLevel < 10 || hungerLevel > 95) {
                    break;
                }
            }
        }

        pound.changePicture("tired");
        pound.updateStats();
    }

    /**
     * Method so dog can eat; Dog can only eat if their hunger level is greater
     * than zero, and if dog eats, weight changes
     */
    public void eat() {
        if (hungerLevel > 0) {
            setEnergyLevel(energyLevel + 4);
            setAggressionLevel(aggressionLevel - 3);

            while (hungerLevel > 0) {
                setHungerLevel(hungerLevel - 3);
                weight += 0.001;

                pound.changePicture("eat");
                pound.updateStats();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException error) {
                    System.err.println(error.getMessage());
                } catch (Exception error) {
                    System.err.println(error.getMessage());
                }
            }
            pound.changePicture("default");
        }
    }

    /**
     * Plays a growl sound for the dog, and updates stats to indicate increased
     * aggression
     *
     */
    public void attack() {
        String soundName = "dog_growl.wav";

        if (aggressionLevel < 75) {
            try {
                AudioInputStream ais
                        = AudioSystem.getAudioInputStream(getClass().getResource(soundName));
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
                ais.close();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }

        while (aggressionLevel < 75) {
            setAggressionLevel(aggressionLevel + 2);
            weight -= 0.001;

            pound.changePicture("beast");
            pound.updateStats();

            try {
                Thread.sleep(500);
            } catch (InterruptedException error) {
                System.err.println(error.getMessage());
            } catch (Exception error) {
                System.err.println(error.getMessage());
            }
        }
        pound.changePicture("default");

    }

    /**
     * Plays a bark sound for the dog, and plays a different sound depending on
     * the dog's weight
     */
    public void bark() { // Need to add sound
        String soundName;

        if (weight < 8.5) {
            System.out.println("Yip, Yip");
            soundName = "bark_1.wav";
        } else if (weight < 25.0) {
            System.out.println("Ruff, Ruff");
            soundName = "bark_2.wav";
        } else if (weight < 40.0) {
            System.out.println("Bark, Bark");
            soundName = "bark_3.wav";
        } else {
            System.out.println("Woof, Woof");
            soundName = "bark_4.wav";
        }

        try {
            AudioInputStream ais
                    = AudioSystem.getAudioInputStream(getClass().getResource(soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            ais.close();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dog sleeps until its energy level is at 100, and it cannot sleep if its
     * energy level is at 100
     *
     * When sleeping, hunger increases and aggression decreases
     */
    public void sleep() {
        if (energyLevel < 100) {
            setHungerLevel(hungerLevel + 4);
            setAggressionLevel(aggressionLevel - 3);

            while (energyLevel < 100) {
                setEnergyLevel(energyLevel + 3);
                weight -= 0.001;

                pound.changePicture("sleep");
                pound.updateStats();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException error) {
                    System.err.println(error.getMessage());
                } catch (Exception error) {
                    System.err.println(error.getMessage());
                }
            }
            pound.changePicture("default");
        }
    }

}
