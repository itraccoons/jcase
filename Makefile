.PHONY: validate
validate:
	ls -la .circleci/scripts/validate/linter

.PHONY: build
build:
	.circleci/scripts/build/gradle

.PHONY: test-unit
test-unit:
	.circleci/scripts/test/unit
