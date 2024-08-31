SRC_DIR := src
OUTPUT_DIR := bin
LIB_DIR := lib

JC := javac

default: generate-parser 
	$(JC) -cp .:$(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/*.java \
	$(SRC_DIR)/lang/parser/*.java \
	$(SRC_DIR)/lang/ast/*.java \
	$(SRC_DIR)/lang/ast/nodes/*.java \
	$(SRC_DIR)/lang/ast/nodes/base/*.java \
	$(SRC_DIR)/lang/ast/nodes/definitions/*.java \
	$(SRC_DIR)/lang/ast/nodes/definitions/base/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/base/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/binaryOperators/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/binaryOperators/base/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/literals/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/variables/*.java \
	$(SRC_DIR)/lang/ast/nodes/expressions/variables/base/*.java \
	$(SRC_DIR)/lang/ast/nodes/types/*.java \
	$(SRC_DIR)/lang/ast/nodes/types/base/*.java \
	$(SRC_DIR)/lang/visitors/*.java \
	-d $(OUTPUT_DIR)

generate-parser:
	java -jar $(LIB_DIR)/antlr-4.8-complete.jar $(SRC_DIR)/lang/parser/lang.g4

run-tests:
	java -cp .:$(LIB_DIR)/antlr-4.8-complete.jar:$(OUTPUT_DIR) LangCompiler -bs

run:
	java -cp .:$(LIB_DIR)/antlr-4.8-complete.jar:$(OUTPUT_DIR) LangCompiler -byt $(FILE)

clean:
	rm -rf $(OUTPUT_DIR)/*