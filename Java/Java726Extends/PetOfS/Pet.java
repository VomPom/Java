package WORK.Java.Java726Extends.PetOfS;

public class Pet {
	private Animal[] animal;

	public void get() {
		for(Animal s:animal) {
			System.out.println(s.getName()+" "+s.getAge()+" "+s.getColor()+" "+s.getPrice());
		}
	}
	public void select(String name) {
		for(int i=0;i<animal.length;i++) {
			if(animal[i].getName().equals(name))
			System.out.println(animal[i].getName()+" "+animal[i].getAge()+" "+animal[i].getColor()+" "+animal[i].getPrice());
		}
	}
	public Animal[] getAnimal() {
		return animal;
	}

	public void setAnimal(Animal[] animal) {
		this.animal = animal;
	}
	

}
