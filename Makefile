# Makefile based wrapper for automating building Java Projects
# with Gradle locally and with Docker on CircleCI
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

.DEFAULT_GOAL := help

.PHONY: help
help: ## Print this help
	@echo "List of available commands:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions

.PHONY: yamllint
yamllint: ## Run YAML Lint
	sh -c '.circleci/scripts/validate/yamllint.sh'

.PHONY: shellcheck
shellcheck: ## Run Shellcheck
	sh -c '.circleci/scripts/validate/shellcheck.sh'

.PHONY: ktlint
ktlint: ## Run an anti-bikeshedding Kotlin linter
	sh -c '.circleci/scripts/validate/ktlint.sh'

.PHONY: checkstyle
checkstyle: ##
	sh -c '.circleci/scripts/validate/checkstyle.sh'

.PHONY: validate-ci
validate-ci: yamllint shellcheck ktlint ## Validate CI configuration
#	time make yamllint
#	time make shellcheck

.PHONY: validate-src
validate-src: checkstyle ## Validate Source Code

.PHONY: test-unit
test-unit: ## Run Unit tests
	sh -c '.circleci/scripts/test/unit.sh'

.PHONY: test-coverage
test-coverage: ## Run test coverage
	sh -c '.circleci/scripts/test/coverage.sh'

.PHONY: lint
lint: validate-ci validate-src ## Run all linters

.PHONY: build
build: ## Build a version
	sh -c '.circleci/scripts/build/gradlew.sh'

.PHONY: docs
docs: ## [stub] Generate documentation
	echo "docs stub"
#	sh -c '.circleci/scripts/build/docs.sh'

.PHONY: test
test: test-unit test-coverage ## Run all tests

.PHONY: release
release: ## [stub] Deploy a version
	echo "deploy stub"

.PHONY: deploy
deploy: ## [stub] Deploy a version
	echo "deploy stub"

.PHONY: clean
clean: ## Clean workspace
	sh -c '.circleci/scripts/clean.sh'
