package BuilderPatternExample;

public class Computer {
	    // Attributes of the Computer
	    private String CPU;
	    private String RAM;
	    private String storage;
	    private String graphicsCard;
	    private String powerSupply;
	    private String motherboard;

	    // Private constructor to take Builder as parameter
	    private Computer(Builder builder) {
	        this.CPU = builder.CPU;
	        this.RAM = builder.RAM;
	        this.storage = builder.storage;
	        this.graphicsCard = builder.graphicsCard;
	        this.powerSupply = builder.powerSupply;
	        this.motherboard = builder.motherboard;
	    }

	    @Override
	    public String toString() {
	        return "Computer{" +
	                "CPU='" + CPU + '\'' +
	                ", RAM='" + RAM + '\'' +
	                ", storage='" + storage + '\'' +
	                ", graphicsCard='" + graphicsCard + '\'' +
	                ", powerSupply='" + powerSupply + '\'' +
	                ", motherboard='" + motherboard + '\'' +
	                '}';
	    }

	    // Static nested Builder class
	    public static class Builder {
	        private String CPU;
	        private String RAM;
	        private String storage;
	        private String graphicsCard;
	        private String powerSupply;
	        private String motherboard;

	        // Methods to set each attribute
	        public Builder setCPU(String CPU) {
	            this.CPU = CPU;
	            return this;
	        }

	        public Builder setRAM(String RAM) {
	            this.RAM = RAM;
	            return this;
	        }

	        public Builder setStorage(String storage) {
	            this.storage = storage;
	            return this;
	        }

	        public Builder setGraphicsCard(String graphicsCard) {
	            this.graphicsCard = graphicsCard;
	            return this;
	        }

	        public Builder setPowerSupply(String powerSupply) {
	            this.powerSupply = powerSupply;
	            return this;
	        }

	        public Builder setMotherboard(String motherboard) {
	            this.motherboard = motherboard;
	            return this;
	        }

	        // Build method to return an instance of Computer
	        public Computer build() {
	            return new Computer(this);
	        }
	    }
	}


