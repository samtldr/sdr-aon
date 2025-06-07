

boolean checkStudy(Student student) { // I would be very interested to see the context of this method call. Is it apart of a service? 
									  // The method name is ok, but not great because I'm not 100% certain what it is by looking at it
									  // For the purpose of this exercise I'm going to make the assumption that we are checking if a particular student is allowed to study on a particular 'studying system' for a University
									  // If that's the case, I would prefer something like 'canStudy' 
	if (student.isLoggedIn()) {                     // Is the logged in state really stored on the Student Object ? Hard to critique this without seeing full context
		if (student.getTeacherName() == "Lee") {    // Does the Student Object really contain a reference to teacher ? Can't a student have more than one teacher and teachers teach more than one student? If student has a teacher reference there would be bigger design concerns than this developers code. 
													// You would be more likely to use a service to maintain the many to many relationship
													// In addition, this will not behave how we expect because the == operator will compare Object reference when comparing Strings (Use equalsTo instead)
													// Even if it did work, Directly referencing a name like that limits you to "Lee" with upper case (L). What if the casing is off for that teacher name (eg 'lee') ? Could use equalsIgnoreCase instead 
													// Lastly, Shouldn't it be stored as first name and last name?
			if (student.isEnrolledInMaths()) {          //More likely to use a service to maintain many to many relationship (student enrolled in many classes, classes enrol many students)
				if (student.hasDistinction())              //Same comment
					return true;
			}
		}
	}                                   //The nested If statements bother me greatly, If you had a service that was checking if a student can study it would make more sense to do a step by step validation like below
										//In addition, it would be much better to return relevant exceptions or messages based on the actual failing validations. You could handle it here or in the nested methods.
										//boolean studentCanStudy(Student student, Teacher teacher) {
										//    if(!student.isLogged()) {
										//        return new StudentNotLoggedInException();
										//    }
										//    if(!teachersService.studentHasTeacher(student, teacher) {
										//        return new IncorrectTeacherException();
										//    }
										//    // and so on...
										//
										//}
										// I need to be clear though, context is very important here as there are certain compromises we can make in the name of satifying business requirements quickly
										// For example, we may not be able to quickly change the Student model to match my raised issues above. 
										// We may need to open up a separate project to refactor
										// Code and design aside, I would certainly be raising questions about the requirements, why are only distinction students, enrolled in maths under teacher Lee allowed to study?!
							
	return false;
}
