import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerPreguntas(params) {
        return Api().get('pregunta/')
    },
    obtenerPreguntasPorEncuesta(params) {
        console.log(params)
        return Api().get('pregunta/porEncuesta/'+params.idEncuesta)
    },
}