import java.util.*;
import java.io.*;

public class PhysiciansHelper
{
        // Scanner for user input
        private Scanner scanner;
        
	// symptom to illnesses map 
	private Map<String, List<String>> symptomChecker;

	/* Constructor symptomChecker map using TreeMap */
	public PhysiciansHelper()
	{ 
		// use TreeMap, i.e. sorted order keys
		symptomChecker = new TreeMap<String,List<String>>();
	} // end default constructor
        
        private List<String> patientSymptoms = new ArrayList<>();
        
        private Map<String,Integer> illnessToFrequency = new TreeMap<>();
        
        private int maxCounter = 0;
        
        private Integer frequency = null;
        
        public void readFile(Scanner data)
	{
            data.useDelimiter(":"); // skip non letter/digit/underscore chars
            while(data.hasNextLine())
            {
                String s = data.nextLine();
                String[] line = s.split(":");
                String disease = line[0].trim();
                String symptomsPart = line[1].toLowerCase();
                String[] symptoms = symptomsPart.trim().split("\\s*,\\s*");
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
            data.close();
        }
	/* Reads a text file of illnesses and their symptoms.
	   Each line in the file has the form
		Illness: Symptom, Symptom, Symptom, ...  
	   Store data into symptomChecker map */

	public void processDatafile()
	{
		// Step 1: read in a data filename from keybaord
		//         create a scanner for the file

		// Step 2: process data lines in file scanner
		// 2.1 for each line, split the line into a disease and symptoms
		//     make sure to trim() spaces and use toLowercase()
		// 2.2 for symptoms, split into individual symptom
		//     create a scanner for symptoms 
		//     useDelimeter(",") to split into individual symptoms 
		//     make sure to trim() spaces and use toLowercase()
		//     for each symptom
		//        if it is already in the map, insert disease into related list
		//        if it is not already in the map, create a new list with the disease
		// Step 3: display symptomChecker map

		// implement here.....
            System.out.print("Enter data file name: ");
            Scanner sc = new Scanner(System.in);
            String fileName = sc.nextLine();
            File file = new File(fileName);
            try
            {
                Scanner data = new Scanner(file);
                readFile(data);
            }
            catch(FileNotFoundException e)
            {
		System.out.println("File not found: " +e.getMessage());
            }
            catch(IOException e)
            {
            	System.out.println("I/O error" + e.getMessage());
            }
            System.out.println("============================================");
            System.out.println("symptomChecker map:");
            symptomChecker.forEach((key, value) -> System.out.println(key + ":" + value));
	} // end processDatafile



	/*  Read patient's symptoms in a line and adds them to the list.
		Input format: Symptom, Symptom, Symptom,...
	    Shows diseases that match a given number of the symptoms. */

	public void processSymptoms()
	{

		// Step 1: get all possible symptoms from assciatedIllnesses map
		//         and display them
		// Step 2: process patient symptoms, add to patientSymptoms list 
		//         read patient's symptoms in a line, separated by ','
		//         create a scanner for symptoms 
		//         UseDelimeter(",") to split into individual symptoms 
		//         make sure to trim() spaces and use toLowercase()
		//         display invalid/duplicate symptoms
		//         add valid symptoms to patientSymptoms list
		// Step 3: display patientSymptoms list
   	        // Step 4: process illnesses to frequency count
		//         create a map of disease name and frequency count
		//         for each symptom in patientSymptoms list
		//              get list of illnesses from symptomChecker map
		//              for each illness in the list
		// 	            if it is already in the map, increase counter by 1
	        //	            if it is not already in the map, create a new counter 1
		//         ** need to keep track of maximum counter numbers
		// Step 5: display result
		//         for count i = 1 to maximum counter number
		//             display illness that has count i
            
            //Prints Symptoms
            System.out.println("============================================"+"\n");
            System.out.println("Possible Symptoms are:");
            symptomChecker.forEach((key, value) -> System.out.println(key));
            System.out.println("============================================"+"\n");
            
            System.out.print("Enter Symptoms: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] symptomArr = s.toLowerCase().trim().split("\\s*,\\s*");
            for(String symptom : symptomArr)
            {
                if(!symptomChecker.containsKey(symptom))
                {
                    System.out.println("\t=>invalid symptom:"+symptom);
                }
                else if(!patientSymptoms.contains(symptom))
                {
                    patientSymptoms.add(symptom);
                }
                else if(patientSymptoms.contains(symptom))
                {
                    System.out.println("\t=>duplicate symptom:"+symptom);
                }
            }
            
            System.out.println("\n"+"============================================\n");
            
            //prints patient symptoms
            System.out.print("PatientSymptom List: " + " [");
            for(String symptom : patientSymptoms)
            {
                System.out.print(symptom + ",");
            }
            System.out.println("]\n");
            
            for(String symptom : patientSymptoms)
            {
                List<String> symptomList = symptomChecker.get(symptom);
                for(String illness : symptomList)
                {
                    frequency = illnessToFrequency.get(illness);
                    if(illnessToFrequency.get(illness)== null)
                    {
                        frequency = 1;
                        illnessToFrequency.put(illness,frequency);
                    }
                    else
                    {
                        frequency++;
                        illnessToFrequency.put(illness,frequency);
                    }
                    if(frequency>maxCounter)
                        maxCounter = frequency;
                }
            }
            
            System.out.println("Possible illnesses that match any symptom are: \n");
            for(int i = 1;i<maxCounter+1;i++)
            {
                System.out.println("==> Disease(s) match " + i + " symptom(s)");
                for(String key : illnessToFrequency.keySet())
                {
                    if(illnessToFrequency.get(key) == i)
                        System.out.println(key);
                }
                System.out.println("\n");
            }
	} // end processSymptoms 


	public static void main(String[] args)
	{

		PhysiciansHelper lookup = new PhysiciansHelper();
		lookup.processDatafile();
		lookup.processSymptoms();
	} // end main
} // end PhysiciansHelper
