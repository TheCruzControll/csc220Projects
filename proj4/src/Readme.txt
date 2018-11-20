		CSC220 Programming Project #4
		=============================

Due Date: 11:55pm, Monday, 12/17, upload PhysiciansHelper.java to ilearn

Project Statement:  Taken from Project 5, Chapter 19, Page 573. 
==================
Suppose that we want to help physicians to diagnose illnesses.  A physician 
observes a patient's symptoms and considers the illnesses that could be 
associated with those symptoms.  Design and implement a class PhysiciansHelper 
that provide a list of those illnesses. 

PhysiciansHelper should contain a dictionary of illnesses and symptoms. 
A method should read a text file of illnesses and their symptoms into 
the dictionary. See format in sample data file.

PhysiciansHelper should read a list of symptoms for a patient.  
A method should read a list of symptoms and store into a list. 
Then, it finds a list illnesses that are associated with those symptoms. 
See format in sample run output.

Note: I have modified specification and requirements of this project

Project requirements:
=====================
You will need to complete two methods in PhysiciansHelper class:
	public void processDatafile(); 	
	public void processSymptoms();
Refer to PhysiciansHelper for detailed info.

* You must use the predefined  private Map<String, List<String>> symptomChecker 
  to store symptoms to illnesses mapping info. See format in sample run output.

* All string data are not case sensitive, i.e. should work for either uppercase 
  or lowercase letters.

* In processSymptoms() methods, you must 
  - list possible symptoms in sorted order.
  - read user input symptoms in single line
  - check for invalid symptoms and eliminate duplicated symptoms
  - display result in format as shown in sample output (must count number of matched symptoms)

* Use Java API Map and List in your project
  https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
  https://docs.oracle.com/javase/8/docs/api/java/util/List.html

  Here are some methods that you may need: 
	Map: get(), put(), containsKey(), keySet(), entrySet()
	List: add(), contains(), size()

	
Sample Run: Note: I expect similar output from your program
==========

$ cat sample_data.txt			// contents of sample data file
cold: runny nose, cough, sore throat
flu: runny nose, cough, sore throat, muscle aches, fever
mumps: high fever, rash, swelling
whooping cough: cough, rash, high fever
acid reflux: chest pain, burping
chickenpox: fever, blister
measles : runny nose, cough, fever, rash
norovirus : nausea, diarrhea, vomiting
ague: sweatiness, achy, high fever

$ javac PhysiciansHelper.java

$ java PhysiciansHelper
Enter data filename: sample_data.txt

============================================
symptomChecker map:			// display contents of map
achy=[ague]
blister=[chickenpox]
burping=[acid reflux]
chest pain=[acid reflux]
cough=[cold, flu, whooping cough, measles]
diarrhea=[norovirus]
fever=[flu, chickenpox, measles]
high fever=[mumps, whooping cough, ague]
muscle aches=[flu]
nausea=[norovirus]
rash=[mumps, whooping cough, measles]
runny nose=[cold, flu, measles]
sore throat=[cold, flu]
sweatiness=[ague]
swelling=[mumps]
vomiting=[norovirus]
============================================

The possible symptoms are: 		// display symptoms in sorted order
achy
blister
burping
chest pain
cough
diarrhea
fever
high fever
muscle aches
nausea
rash
runny nose
sore throat
sweatiness
swelling
vomiting

============================================

Enter symptoms: cough,rash,cough,fever,blisterx,cough,runny NOSE
         =>duplicate symptom:cough
         =>invalid symptom:blisterx
         =>duplicate symptom:cough

============================================

PatientSymptoms list: [cough, rash, fever, runny nose]

Possible illnesses that match any symptom are:

==> Disease(s) match 1 symptom(s)
chickenpox
mumps

==> Disease(s) match 2 symptom(s)
whooping cough
cold

==> Disease(s) match 3 symptom(s)
flu

==> Disease(s) match 4 symptom(s)
measles

