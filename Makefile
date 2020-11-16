# defalt goal is both
.DEFAULT_GOAL := all

SBT=sbt
ROOT_DIR := $(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
MASTER_DIR := $(ROOT_DIR)/master
SLAVE_DIR := $(ROOT_DIR)/slave
STAGED_PATH := /target/universal/stage/bin


all : bin
	$(SBT) stage
	ln -fs $(MASTER_DIR)$(STAGED_PATH)/master $(ROOT_DIR)/bin/master
	ln -fs $(SLAVE_DIR)$(STAGED_PATH)/slave $(ROOT_DIR)/bin/slave

master : bin
	$(SBT) master/stage
	ln -fs $(MASTER_DIR)$(STAGED_PATH)/master $(ROOT_DIR)/bin/master

slave : bin
	$(SBT) slave/stage
	ln -fs $(SLAVE_DIR)$(STAGED_PATH)/slave $(ROOT_DIR)/bin/slave

bin : 
	mkdir -p $(ROOT_DIR)/bin

clean :
	$(SBT) clean
	rm -f $(ROOT_DIR)/bin/master $(ROOT_DIR)/bin/slave
	rmdir bin