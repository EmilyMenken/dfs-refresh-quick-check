import java.util.*;

public class Problem {
    /**
     * Returns how many salamanders less than 3 years old will be at risk from a
     * serious infection if a given salamander is infected.
     * 
     * When a salamander is infected, it will pass the disease along to all of
     * its contacts. Each of those contacts will pass it on to their contacts
     * and so on. Salamanders of any age can catch and spread the disease, but
     * it is only a serious risk for salamanders strictly less than 3 years old.
     * 
     * Include the initial patient in the count if the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */
    public static int countSeriousInfections(Salamander initialPatient) {
        
        //getAge < 3
        
        Set<Salamander> visited = new HashSet<>();
        List<Salamander> infected = new ArrayList<>();
        
        countSeriousInfectionsHelper(initialPatient, visited, infected);
        
        return infected.size();

    }//end countSeriousInfections

    public static void countSeriousInfectionsHelper(Salamander initialPatient, Set<Salamander> visited, List<Salamander> infected){


        if(initialPatient == null || visited.contains(initialPatient)){

            return;

        }//end if

         visited.add(initialPatient);

        if(initialPatient.getAge() <3){

            infected.add(initialPatient);

        }//end if

        for(Salamander s : initialPatient.getContacts()){

            countSeriousInfectionsHelper(s, visited, infected);

        }//end for

    }//end countSeriousInfectionsHelper



}//end file
