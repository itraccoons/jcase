# Makefile based wrapper for automating building Java Projects
# with Gradle locally and within Docker on CircleCI
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

.DEFAULT_GOAL := help

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c := sh -c


.PHONY: help
help: ## Print this help
	@echo "List of available commands:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: yamllint
yamllint: depends ## Run linter for YAML files
	$(sh_c) '.circleci/scripts/validate/yamllint.sh'

.PHONY: shellcheck
shellcheck: depends ## Run static analysis of shell scripts
	$(sh_c) '.circleci/scripts/validate/shellcheck.sh'

.PHONY: ktlint
ktlint: ## Run an anti-bikeshedding Kotlin linter
	$(sh_c) '.circleci/scripts/validate/ktlint.sh'

.PHONY: checkstyle
checkstyle: ## Run static code analysis of Java source code
	$(sh_c) '.circleci/scripts/validate/checkstyle.sh'

.PHONY: validate-ci
validate-ci: yamllint shellcheck ktlint ## Validate CI configuration

.PHONY: validate-src
validate-src: checkstyle ## Validate Source Code



.PHONY: test-unit
test-unit: ## Run Unit tests
	$(sh_c) '.circleci/scripts/test/unit.sh'

.PHONY: test-coverage
test-coverage: ## Run test coverage
	$(sh_c) '.circleci/scripts/test/coverage.sh'



.PHONY: depends
depends: ## Install software dependencies
	$(sh_c) '.circleci/scripts/install/depends.sh'



.PHONY: build-code
build-code: ## Build  Code
	$(sh_c) '.circleci/scripts/build/gradlew.sh'

.PHONY: build-docs
build-docs: ## [stub] Generate documentation
	echo "build docs stub"
#	$(sh_c) '.circleci/scripts/build/docs.sh'

.PHONY: build-image
build-image: ## Build Image
	$(sh_c) '.circleci/scripts/build/skaffold.sh'



.PHONY: lint
lint: validate-ci validate-src ## Run all linters

.PHONY: build
build: build-code ## Build a version

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
	$(sh_c) '.circleci/scripts/clean.sh'



.PHONY: open
open: ## [*] Open Build Dashboard (macOS local job)
	$(sh_c) 'open build/reports/buildDashboard/index.html'

.PHONY: run
run: ## [*] Run this project as a JVM application
	$(sh_c) './gradlew run'