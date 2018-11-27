

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author franciscruz
 */
public class NewClass {
    
        
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Map<String, List<String>> symptomChecker = new HashMap<String,List<String>>();
        Scanner sc = new Scanner(System.in);
        String fileName = "sample_data.txt";
        File file = new File(fileName);
        
        //Put in try/catch
        Scanner data = new Scanner(file);
        
        //Put in readFile method
        data.useDelimiter(":");
        while(data.hasNextLine())
        {
            String s = data.nextLine();
            String[] line = s.split(":");
            String disease = line[0];
            String symptomsPart = line[1].toLowerCase();
            String[] symptoms = symptomsPart.trim().split("\\s*,\\s*");
            System.out.println(disease);
            
            for(String symptom : symptoms)
            {
                
                if(symptomChecker.containsKey(symptom) == false)
                {
                   List<String> diseases = new ArrayList<>();
                       diseases.add(disease);
                       symptomChecker.put(symptom,diseases);

                    System.out.println("Added new Symptom: "+ symptom);
                }
                else
                {
                   if(symptomChecker.get(symptom) == null)
                   {
                       List<String> diseases = new ArrayList<>();
                       diseases.add(disease);
                       symptomChecker.put(symptom,diseases);
                       System.out.println("Added new disease: " + disease);
                   }
                   else
                   {
                       List<String> tempSymptoms = symptomChecker.get(symptom);
                       tempSymptoms.add(disease);
                       symptomChecker.put(symptom,tempSymptoms);
                       System.out.println("Added new disease: " + disease);
                   }
                }
            }
        }
        symptomChecker.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
