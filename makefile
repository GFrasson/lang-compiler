# Equipe:
# ÁGATA MEIRELES CARVALHO - 202065001C
# GABRIEL FRASSON COSTA - 202035001

# Versão do JAVA: 11.0.22

SRC_DIR := src
OUTPUT_DIR := target
LIB_DIR := lib

JC := javac

default: generate-parser generate-scanner 
	$(JC) $(SRC_DIR)/*.java $(SRC_DIR)/lang/scanner/*.java $(SRC_DIR)/lang/parser/*.java $(SRC_DIR)/lang/ast/*.java -d $(OUTPUT_DIR)

generate-parser:
	java -jar $(LIB_DIR)/beaver-cc-0.9.11.jar -T $(SRC_DIR)/lang/parser/lang.grammar

generate-scanner:
	java -jar $(LIB_DIR)/jflex-full-1.8.2.jar $(SRC_DIR)/lang/scanner/lang.jflex

run:
	java -cp .:$(LIB_DIR)/beaver-rt-0.9.11.jar $(OUTPUT_DIR) App $(FILE)

clean:
	rm -rf $(OUTPUT_DIR)/*




# compile: genparser genlex
# 	javac -cp .:beaver-rt-0.9.11.jar Teste.java

# genparser: parsers/lang.grammar
# 	java -jar beaver-cc-0.9.11.jar -T parsers/lang.grammar

# genlex: parsers/lang.jflex genparser
# 	java -jar jflex-full-1.8.2.jar parsers/lang.jflex

# run: compile
# 	java -cp .:beaver-rt-0.9.11.jar Teste $(filter-out $@,$(MAKECMDGOALS))

# clean:
# 	rm -R parsers/MiniLang*.java parsers/Terminals.java
# 	find . -type f -name "*.class" -delete
# 	find . -type f -name "*~" -delete
