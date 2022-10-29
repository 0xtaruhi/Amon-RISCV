SBT ?= sbt

.PHONY: all
	${SBT} run

.PHONY clean:
	rm -rf rtl
	@echo "Cleaned up"
