import Api from '@/services/Api'
/* eslint-disable */
export default {
    guardar(params) {
        console.log("params:"+params)
        return Api().post('respuesta/guardar',params)
    },
    obtenerResultados(params) {
        console.log(params)
        return Api().get('respuesta/resultados/'+params.idEncuesta)
    },
}