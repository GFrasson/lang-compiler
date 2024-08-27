SRC_DIR := src
OUTPUT_DIR := target
LIB_DIR := lib

JC := javac

# compile: genparser $(SRC_DIR)/App.java
# 	javac -cp .:$(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/App.java

# genparser: $(SRC_DIR)/parser/lang.g4
# 	java -jar $(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/parser/lang.g4

# run: compile genparser
# 	java -cp .:$(LIB_DIR)/antlr-4.8-complete.jar App $(filter-out $@,$(MAKECMDGOALS))

# clean:
# 	rm -R $(SRC_DIR)/parser/*Listener.java $(SRC_DIR)/parser/langLexer* $(SRC_DIR)/parser/langParser.java $(SRC_DIR)parser/lang.interp $(SRC_DIR)parser/lang.tokens
# 	find . -type f -name "*.class" -delete
# 	find . -type f -name "*~" -delete


default: generate-parser 
	$(JC) -cp .:$(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/*.java $(SRC_DIR)/lang/parser/*.java -d $(OUTPUT_DIR)

generate-parser:
	java -jar $(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/lang/parser/lang.g4

run:
	java -cp .:$(LIB_DIR)/antlr-4.8-complete.jar:$(OUTPUT_DIR) LangCompiler $(FILE)

clean:
	rm -rf $(OUTPUT_DIR)/*