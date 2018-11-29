

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
        
        Map<String, List<String>> symptomChecker = new TreeMap<String,List<String>>();
        Map<String,Integer> illnessToFrequency = new TreeMap<>();
        Integer frequency = 0;
        System.out.print("Enter data file name: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);
        
        //Put in try/catch
        Scanner data = new Scanner(file);
        
        //Put in readFile method
        data.useDelimiter(":");
        while(data.hasNextLine())
        {
            String s = data.nextLine();
            String[] line = s.split(":");
            String disease = line[0].trim();
            String symptomsPart = line[1].toLowerCase();
            String[] symptoms = symptomsPart.trim().split("\\s*,\\s*");
            System.out.println(disease);
            
            for(String symptom : symptoms)
            {
                if(symptomChecker.get(symptom) == null)
                {
                   List<String> diseases = new ArrayList<>();
                   diseases.add(disease);
                   symptomChecker.put(symptom,diseases);
                }
                else
                {
                    List<String> tempSymptoms = symptomChecker.get(symptom);
                    tempSymptoms.add(disease);
                    symptomChecker.put(symptom,tempSymptoms);
                }
            }
        }
        
        symptomChecker.forEach((key, value) -> System.out.println(key + ":" + value));
        List<String> patientSymptoms = new ArrayList<>();
        System.out.print("Enter Symptoms: ");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            String[] symptomArr = s.toLowerCase().trim().split(",");
            for(String symptom : symptomArr)
            {
                if(!symptomChecker.containsKey(symptom))
                {
                    System.out.println("=>invalid symptom:"+symptom);
                }
                else if(!patientSymptoms.contains(symptom))
                {
                    patientSymptoms.add(symptom);
                }
                else if(patientSymptoms.contains(symptom))
                {
                    System.out.println("=>duplicate symptom:"+symptom);
                }
            }
            System.out.print("PatientSymptom List: " + " [");
            for(String symptom : patientSymptoms)
            {
                System.out.print(symptom + ",");
            }
            System.out.println("]");
            
            int maxCounter = 0;
            
            for(String symptom : patientSymptoms)
            {
                List<String> symptomList = symptomChecker.get(symptom);
                for(String illness : symptomList)
                {
                    
                    if(illnessToFrequency.containsKey(illness) == false)
                    {
                        frequency = 1;
                        illnessToFrequency.put(illness,frequency);
                    }
                    else if(illnessToFrequency.containsKey(illness))
                    {
                        frequency = illnessToFrequency.get(illness);
                        frequency++;
                        illnessToFrequency.put(illness,frequency);
                    }
                    if(frequency>maxCounter)
                        maxCounter = frequency;
                }
            }
            
            illnessToFrequency.forEach((key, value) -> System.out.println(key + ":" + value));
            for(int i = 1;i<maxCounter+1;i++)
            {
                System.out.println("==> Disease(s) match " + i + " symptom(s)");
                for(String key : illnessToFrequency.keySet())
                {
                    if(illnessToFrequency.get(key) == i)
                        System.out.println(key);
                }
            }
            System.out.println(maxCounter);
    }
}
