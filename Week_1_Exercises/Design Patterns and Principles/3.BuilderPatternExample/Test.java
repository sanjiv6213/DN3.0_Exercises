package BuilderPatternExample;

public class Test {
	    public static void main(String[] args) {
	        // Creating different configurations of Computer using Builder pattern
	        Computer gamingComputer = new Computer.Builder()
	                .setCPU("Intel Core i9")
	                .setRAM("32GB")
	                .setStorage("1TB SSD")
	                .setGraphicsCard("NVIDIA GeForce RTX 3080")
	                .setPowerSupply("750W")
	                .setMotherboard("ASUS ROG")
	                .build();

	        Computer officeComputer = new Computer.Builder()
	                .setCPU("Intel Core i5")
	                .setRAM("16GB")
	                .setStorage("512GB SSD")
	                .setGraphicsCard("Integrated")
	                .setPowerSupply("500W")
	                .setMotherboard("Gigabyte")
	                .build();

	        System.out.println("Gaming Computer Configuration:");
	        System.out.println(gamingComputer);

	        System.out.println("\nOffice Computer Configuration:");
	        System.out.println(officeComputer);
	    }
	}


