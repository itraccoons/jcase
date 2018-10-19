# Makefile based wrapper for automating building Java Projects
# with Gradle locally and with Docker on CircleCI
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

.DEFAULT_GOAL := help

.PHONY: help
help: ## Print this help
	@echo "List of available commands:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
#	Replace own self-documented Makefile to https://marmelab.com/blog/2016/02/29/auto-documented-makefile.html
#	@grep "^[A-z]*:.#" $(MAKEFILE_LIST) | sed "s/[:,#]//g"

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions

.PHONY: yamllint
yamllint: ## Run YAML Lint
	sh -c '.circleci/scripts/validate/yamllint.sh'

.PHONY: shellcheck
shellcheck: ## Run Shellcheck
	sh -c '.circleci/scripts/validate/shellcheck.sh'

.PHONY: lint
lint: ## Run linters for source code
	sh -c '.circleci/scripts/validate/lint.sh'

.PHONY: build
build: ## Build a version
	sh -c '.circleci/scripts/build/gradlew.sh'

.PHONY: test
test: ## Run all tests
	sh -c '.circleci/scripts/test/unit.sh'

.PHONY: deploy
deploy: ## Deploy a version
	echo "deploy"

.PHONY: clean
clean: ## Clean workspace
	echo "clean"

.PHONY: validate-ci
validate-ci: yamllint shellcheck ## Validate CI configuration
#	time make yamllint
#	time make shellcheck

.PHONY: validate-src 
validate-src: lint ## Validate Source Code
