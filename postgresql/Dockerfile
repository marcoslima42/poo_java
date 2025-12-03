FROM postgres:latest
ENV REFRESHED_AT=2025-07-30
RUN apt-get update && apt-get install -y locales
RUN touch /usr/share/locale/locale.alias
ENV LANG=pt_BR.UTF-8 	
ENV LANGUAGE=pt_BR:pt
ENV LC_ALL=pt_BR.UTF-8
RUN sed -i '/pt_BR.UTF-8/s/^# //g' /etc/locale.gen && locale-gen && update-locale LANG=pt_BR.UTF-8
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
HEALTHCHECK --interval=30s --timeout=5s --retries=3 CMD sh -c 'pg_isready -d postgres -U postgres'
