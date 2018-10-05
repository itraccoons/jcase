.PHONY: validate
validate:
	.circleci/scripts/validate/linter

.PHONY: build
build:
	.circleci/scripts/build/gradlew

.PHONY: test-unit
test-unit:
	.circleci/scripts/test/unit

.PHONY: deploy
deploy:
	echo "deploy"
