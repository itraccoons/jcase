.PHONY: validate
validate: ## Run all linters
	.circleci/scripts/validate/lint

.PHONY: build
build: ## Build a version
	.circleci/scripts/build/gradlew

.PHONY: test
test: ## Run all tests
	.circleci/scripts/test/unit

.PHONY: deploy
deploy: ## Deploy a version
	echo "deploy"

help: ## Print this help
	@echo "List of available commands:"
#	Replace own self-documented Makefile to https://marmelab.com/blog/2016/02/29/auto-documented-makefile.html
#	@grep "^[A-z]*:.#" $(MAKEFILE_LIST) | sed "s/[:,#]//g"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.DEFAULT_GOAL := help
