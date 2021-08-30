<template>
    <Fieldset :legend="titulo">
      <Toolbar>
        <template #left>
            <Button label="Atras" @click="$router.push('/')" icon="pi pi-arrow-left" class="p-mr-2 p-mb-2"/>
          </template>
      </Toolbar>
      <table>
        <thead>
          <tr>
            <th>
              Codigo
            </th>
            <th>
              Nombre
            </th>
            <th>
              Pregunta
            </th>
            <th>
              Respuesta
            </th>
            <th>
              Cliente
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="resultado in resultados" :key="resultado.numeroPregunta">
            <td>
              {{resultado.codigoEncuesta}}
            </td>
            <td>
              {{resultado.nombreEncuesta}}
            </td>
            <td>
              {{resultado.textoPregunta}}
            </td>
            <td>
              {{resultado.respuesta}}
            </td>
            <td>
              {{resultado.nombreCliente}}
            </td>
          </tr>
        </tbody>
      </table>
    </Fieldset>
</template>

<script>
/* eslint-disable */
import RespuestaServicio from '@/services/RespuestaServicio'


import Fieldset from 'primevue/fieldset';
import Toolbar from 'primevue/toolbar';
import Button from 'primevue/button';

export default {
    name: 'Resultado',
    props:['id'],
    components: {
        Fieldset,
        Toolbar,
        Button
    },
    data (){
      return {
        titulo: "",
         encuesta:{
          id:0,
          nombre:""
        },
        resultados:[],
      }
    },
    methods: {
      async obteneResultados(){
          const response = await RespuestaServicio.obtenerResultados({
            idEncuesta: this.$route.params.id
          });

          console.log(response.data)
          this.resultados = response.data.resultados
          this.encuesta = response.data.encuesta
          this.titulo = this.encuesta.nombre
      }
    },
    mounted() {
        // this.obtenerListadoPreguntas();
        console.log(this.$route.params.id)
        this.obteneResultados();
    },
}
</script>

<style>
.titulo1{
  border-bottom-style: inset
}
</style>