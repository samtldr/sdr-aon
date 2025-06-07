
public class checkStudy {

    boolean checkStudy(Student student) { // I would be very interested to see the context of this method call. Is it apart of a service? 
                                          // The method name is ok, but not great because I'm not 100% certain what it is by looking at it
                                          // I'm going to make the assumption that we are checking if a particular student is allowed to study on a particular 'studying system'.
                                          // If that's the case, I would prefer something like 'canStudy' 
        if (student.isLoggedIn()) {                     // I would be concerned if we are storing 'isLoggedIn' property or function call on the Student Object - that should definitely be apart of a different service (although if we are developing this quickly, refactoring that might not be an option)
            if (student.getTeacherName() == "Lee") {    // Where to begin here? Why on earth would the Teacher name be a property or function of the Student Object. 
                                                        // This should definitely be a call to another service. In addition, this will not work in Java because the == operator will compare Memory objects when comparing Strings (Use equalsTo instead)
                                                        // Even if it did work, Directly referencing a name like that limits you to "Lee" with upper case (L). What if the casing is off for that teacher name (eg 'lee') ? 
                                                        // Lastly, Shouldn't it be stored as first name and last name?
                if (student.isEnrolledInMaths()) {          //Again, should not be a function of student as we would assume enrollment details would be stored other parts of the model (Enrollment Many to Many table in the database?)
                    if (student.hasDistinction())               //Same comment again, should not be a function of student as we would assume the marking would be stored elsewhere
                        return true;
                }
            }
        }                                   //The nested If statements bother me greatly, If you had a service that was checking if a student can study
                                            //In addition, it would be much better to return relevant exceptions or messages based on the actual problem. You could handle it here or in the nested methods.
                                            //boolean canStudy(Student student) {
                                            //    if(!usersService.isLoggedIn(student)) {
                                            //        return new StudentNotLoggedInException();
                                            //    }
                                            //    if(!teachersService.studentHasTeacher(student, "Lee".toLowerCase())) {// obviously better to parse Lee in from somewhere
                                            //        return new IncorrectTeacherName();
                                            //    }
                                            //    // and so on...
                                            //
                                            //}
                                            // I need to be clear though, context is very important here as there are certain compromises we can make in the name of satifying business requirements quickly
                                            // For example, we may not be able to quickly change the Student model to match my raised issues above. 
                                            // We may need to open up a separate project to refactor
                                
        return false;
    }
}


