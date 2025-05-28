<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('habitacions', function (Blueprint $table) {
            $table->id();
            $table->integer('numero_habitacion')->unique();
            $table->foreignId('tipo_habitacion_id')->constrained('tipos_habitacions')->onDelete('cascade');
            $table->double('precio_por_noche');
            $table->string('estado')->default('disponible'); // disponible, ocupado, en_mantenimiento, etc.
            $table->text('descripcion')->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('habitacions');
    }
};
