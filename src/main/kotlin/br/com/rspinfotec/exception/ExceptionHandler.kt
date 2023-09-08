package br.com.rspinfotec.exception


import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Singleton
@Requires(classes = [NotFoudException::class])
class ExceptionHandler : ExceptionHandler<NotFoudException, HttpResponse<*>> {
    override fun handle(request: HttpRequest<*>?, exception: NotFoudException?): HttpResponse<*> {
        val msgError = ErrorMessage(message = exception?.message ?: "Erro")
        return HttpResponse.notFound(msgError)
    }

}