public class HeartChoice {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    public HeartChoice() {
        
        this.listOfPatients=null;
        this.survivabilityByAge=null;
        this.survivabilityByCause=null;

    }

    /* ------ Methods  -------- */

    /*
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {

        int x=listOfPatients.length-1;
        if (arrayIndex >= x) 
            return -1;
        for (int i=x; i>arrayIndex; i--){
            listOfPatients[i]=listOfPatients[i-1];
        }
        listOfPatients[arrayIndex] = p;
            return 0;
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        int i;
        listOfPatients= new Person [numberOfLines];
        for (i=0; i<numberOfLines && StdIn.hasNextLine() ; i++){
        int id=StdIn.readInt();
        int ethnicity=StdIn.readInt();
        int gender=StdIn.readInt();
        int age=StdIn.readInt();
        int cause=StdIn.readInt();
        int urgency=StdIn.readInt();
        int stateOfHealth=StdIn.readInt();
        listOfPatients[i]=new Person(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
        }
        
        return i;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        int i; 
        SurvivabilityByAge=new SurvivabilityByAge [numberOfLines];
        for (i=0; i < numberOfLines && StdIn.hasNextLine(); i++){
        int age=StdIn.readInt();
        int yearsPostTransplant=StdIn.readInt();
        double rate=StdIn.readDouble();
        survivabilityByAge[i]=new SurvivabilityByAge(age, yearsPostTransplant, rate);
        }
        return i;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

        int i;
        survivabilityByCause=new SurvivabilityByCause [numberOfLines];
        for (i=0; i< numberOfLines && StdIn.hasNextLine(); i++){
        int cause=StdIn.readInt();
        int yearsPostTransplant=StdIn.readInt();
        double rate=StdIn.readDouble();
        survivabilityByCause[i]=new SurvivabilityByCause(cause, yearsPostTransplant, rate);
    }
    return i;
}
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {

        int count = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getAge()> age)
                count++;
        }
        if(count == 0)
            return null;
        int index = 0;
        Person[] patientsWithAgeAbove = new Person[count];
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getAge()> age)
                patientsWithAgeAbove[index++] = listOfPatients[i];
        }
        return patientsWithAgeAbove;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     *  
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {

        int count = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getStateOfHealth() == state)
                count++;
        } 
        if(count == 0)
            return null;
        int index = 0;
        Person[] patientsByStateOfHealth = new Person[count];
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getStateOfHealth() == state)
                patientsByStateOfHealth[index++] = listOfPatients[i];
        }
        return patientsByStateOfHealth;
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {

        int count = 0;
            for(int i = 0; i < listOfPatients.length; i++){
                if(listOfPatients[i].getCause() == cause)
                    count++;
        }
            if(count == 0)
                return null;
        int index = 0;
        Person[] patientsByHeartConditionCause = new Person[count];
            for(int i = 0; i < listOfPatients.length; i++){
                if(listOfPatients[i].getCause() == cause)
                    patientsByHeartConditionCause[index++] = listOfPatients[i];
        }
        return patientsByHeartConditionCause;
    }

    /*
     * returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {

        if(numberOfHearts == 0)
       {
        return null;
    }
        if (numberOfHearts <listOfPatients.length){
            
        }
        if(numberOfHearts >= listOfPatients.length){
            return listOfPatients;
}
        Person[] returnList = new Person[numberOfHearts];
        int i = 0;
        for(int j = 0 ; j < survivabilityByCause.length ; j++){
            SurvivabilityByCause c = survivabilityByCause[i];
        int pCount = 0;
        Person[] peeps = getPatientsByHeartConditionCause(c.getCause());
        while(i <= numberOfHearts && pCount < peeps.length){          {
            returnList[i] = peeps[pCount];
            pCount++;
            i++;
}}
}
return returnList;
    }
    
    public static void main (String[] args) {

        HeartChoice ht = new HeartChoice();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

    }
}
