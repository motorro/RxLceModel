# This Dockerfile uses separate build arguments instead of VARIANT
ARG TARGET_JAVA_VERSION=11
ARG BASE_IMAGE_VERSION_CODENAME=bullseye
FROM mcr.microsoft.com/devcontainers/base:${BASE_IMAGE_VERSION_CODENAME}

USER root
ARG TARGET_JAVA_VERSION
ENV JAVA_HOME /usr/lib/jvm/msopenjdk-current
ENV PATH "${JAVA_HOME}/bin:${PATH}"
# Default to UTF-8 file.encoding
ENV LANG en_US.UTF-8

ENV ANDROID_SDK_ROOT /opt/android-sdk-linux/sdk

# Install Microsoft OpenJDK
RUN arch="$(dpkg --print-architecture)" \
	&& case "$arch" in \
		"amd64") \
			jdkUrl="https://aka.ms/download-jdk/microsoft-jdk-${TARGET_JAVA_VERSION}-linux-x64.tar.gz"; \
			;; \
		"arm64") \
			jdkUrl="https://aka.ms/download-jdk/microsoft-jdk-${TARGET_JAVA_VERSION}-linux-aarch64.tar.gz"; \
			;; \
		*) echo >&2 "error: unsupported architecture: '$arch'"; exit 1 ;; \
	esac \
	\
	&& wget --progress=dot:giga -O msopenjdk.tar.gz "${jdkUrl}" \
	&& wget --progress=dot:giga -O sha256sum.txt "${jdkUrl}.sha256sum.txt" \
	\
	&& sha256sumText=$(cat sha256sum.txt) \
	&& sha256=$(expr substr "${sha256sumText}" 1 64) \
	&& echo "${sha256} msopenjdk.tar.gz" | sha256sum --strict --check - \
	&& rm sha256sum.txt* \
	\
	&& mkdir -p "$JAVA_HOME" \
	&& tar --extract \
		--file msopenjdk.tar.gz \
		--directory "$JAVA_HOME" \
		--strip-components 1 \
		--no-same-owner \
	&& rm msopenjdk.tar.gz* \
	\
	&& ln -s ${JAVA_HOME} /docker-java-home \
	&& ln -s ${JAVA_HOME} /usr/local/openjdk-${TARGET_JAVA_VERSION}

# ------------------------------------------------------
# --- Based on Bitrise Android Docker
# --- https://github.com/bitrise-io/android
# ------------------------------------------------------

# ------------------------------------------------------
# --- Install required tools

# Dependencies to execute Android builds
RUN apt-get update -qq

# ------------------------------------------------------
# --- Download Android Command line Tools into $ANDROID_SDK_ROOT

RUN cd /opt \
    && wget -q https://dl.google.com/android/repository/commandlinetools-linux-6858069_latest.zip -O android-commandline-tools.zip \
    && mkdir -m=rwx -p ${ANDROID_SDK_ROOT}/cmdline-tools \
    && unzip -q android-commandline-tools.zip -d /tmp/ \
    && mv /tmp/cmdline-tools/ ${ANDROID_SDK_ROOT}/cmdline-tools/latest \
    && rm android-commandline-tools.zip && ls -la ${ANDROID_SDK_ROOT}/cmdline-tools/latest/

ENV PATH ${PATH}:${ANDROID_SDK_ROOT}/platform-tools:${ANDROID_SDK_ROOT}/cmdline-tools/latest/bin

# ------------------------------------------------------
# --- Install Android SDKs and other build packages

# Other tools and resources of Android SDK
#  you should only install the packages you need!
# To get a full list of available options you can use:
#  sdkmanager --list

# Accept licenses before installing components, no need to echo y for each component
# License is valid for all the standard components in versions installed from this file
# Non-standard components: MIPS system images, preview versions, GDK (Google Glass) and Android Google TV require separate licenses, not accepted there
RUN yes | sdkmanager --licenses

# Platform tools
RUN yes | env PATH=$PATH sdkmanager "platform-tools"

# SDKs

RUN yes | sdkmanager --update --channel=0
# Please keep all sections in descending order!
RUN yes | env PATH=$PATH sdkmanager \
    "platforms;android-33" \
    "platforms;android-32" \
    "platforms;android-31" \
    "platforms;android-30" \
    "build-tools;33.0.1" \
    "build-tools;33.0.0" \
    "build-tools;32.0.0" \
    "build-tools;31.0.0" \
    "build-tools;30.0.3" \
    "build-tools;30.0.2" \
    "build-tools;30.0.1" \
    "build-tools;30.0.0" \
    "extras;android;m2repository" \
    "extras;google;m2repository" \
    "extras;google;google_play_services"


# ------------------------------------------------------
# --- Cleanup and rev num

# Cleaning
RUN apt-get clean