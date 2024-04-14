# Equipe:
# ÁGATA MEIRELES CARVALHO - 202065001C
# GABRIEL FRASSON COSTA - 202035001

SRC_DIR := src
OUTPUT_DIR := target
LIB_DIR := lib

JC := javac

default: generate $(SRC_DIR)/*.java $(SRC_DIR)/**/*.java
	$(JC) $(SRC_DIR)/*.java $(SRC_DIR)/**/*.java -d $(OUTPUT_DIR)

generate:
	java -jar $(LIB_DIR)/jflex-full-1.8.2.jar $(SRC_DIR)/scanner/lang.jflex

run:
	java -cp $(OUTPUT_DIR) App $(FILE)

clean:
	rm -rf $(OUTPUT_DIR)/*