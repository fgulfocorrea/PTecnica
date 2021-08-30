import Api from '@/services/Api'
/* eslint-disable */
export default {
    guardar(params) {
        return Api().post('encuesta/guardar',params)
    },
}