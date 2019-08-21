namespace Matrizes
{
    partial class frmPrincipal
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnDiagonal = new System.Windows.Forms.Button();
            this.btnIdentidade = new System.Windows.Forms.Button();
            this.btnSimetrica = new System.Windows.Forms.Button();
            this.btnTransposta = new System.Windows.Forms.Button();
            this.btnSoma = new System.Windows.Forms.Button();
            this.btnSubtrair = new System.Windows.Forms.Button();
            this.btnMultiplica = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnDiagonal
            // 
            this.btnDiagonal.Location = new System.Drawing.Point(27, 41);
            this.btnDiagonal.Name = "btnDiagonal";
            this.btnDiagonal.Size = new System.Drawing.Size(125, 39);
            this.btnDiagonal.TabIndex = 0;
            this.btnDiagonal.Text = "Matriz Diagonal";
            this.btnDiagonal.UseVisualStyleBackColor = true;
            // 
            // btnIdentidade
            // 
            this.btnIdentidade.Location = new System.Drawing.Point(27, 103);
            this.btnIdentidade.Name = "btnIdentidade";
            this.btnIdentidade.Size = new System.Drawing.Size(125, 39);
            this.btnIdentidade.TabIndex = 1;
            this.btnIdentidade.Text = "Matriz Identidade";
            this.btnIdentidade.UseVisualStyleBackColor = true;
            // 
            // btnSimetrica
            // 
            this.btnSimetrica.Location = new System.Drawing.Point(207, 41);
            this.btnSimetrica.Name = "btnSimetrica";
            this.btnSimetrica.Size = new System.Drawing.Size(125, 39);
            this.btnSimetrica.TabIndex = 2;
            this.btnSimetrica.Text = "Matriz Simétrica";
            this.btnSimetrica.UseVisualStyleBackColor = true;
            // 
            // btnTransposta
            // 
            this.btnTransposta.Location = new System.Drawing.Point(207, 103);
            this.btnTransposta.Name = "btnTransposta";
            this.btnTransposta.Size = new System.Drawing.Size(125, 39);
            this.btnTransposta.TabIndex = 3;
            this.btnTransposta.Text = "Matriz Transposta";
            this.btnTransposta.UseVisualStyleBackColor = true;
            // 
            // btnSoma
            // 
            this.btnSoma.Location = new System.Drawing.Point(27, 169);
            this.btnSoma.Name = "btnSoma";
            this.btnSoma.Size = new System.Drawing.Size(125, 39);
            this.btnSoma.TabIndex = 4;
            this.btnSoma.Text = "Soma de Matriz";
            this.btnSoma.UseVisualStyleBackColor = true;
            // 
            // btnSubtrair
            // 
            this.btnSubtrair.Location = new System.Drawing.Point(207, 169);
            this.btnSubtrair.Name = "btnSubtrair";
            this.btnSubtrair.Size = new System.Drawing.Size(125, 39);
            this.btnSubtrair.TabIndex = 5;
            this.btnSubtrair.Text = "Subtração de Matriz";
            this.btnSubtrair.UseVisualStyleBackColor = true;
            // 
            // btnMultiplica
            // 
            this.btnMultiplica.Location = new System.Drawing.Point(112, 229);
            this.btnMultiplica.Name = "btnMultiplica";
            this.btnMultiplica.Size = new System.Drawing.Size(125, 39);
            this.btnMultiplica.TabIndex = 6;
            this.btnMultiplica.Text = "Multiplicação de Matriz";
            this.btnMultiplica.UseVisualStyleBackColor = true;
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(356, 297);
            this.Controls.Add(this.btnMultiplica);
            this.Controls.Add(this.btnSubtrair);
            this.Controls.Add(this.btnSoma);
            this.Controls.Add(this.btnTransposta);
            this.Controls.Add(this.btnSimetrica);
            this.Controls.Add(this.btnIdentidade);
            this.Controls.Add(this.btnDiagonal);
            this.Name = "frmPrincipal";
            this.Text = "Matrizes";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnDiagonal;
        private System.Windows.Forms.Button btnIdentidade;
        private System.Windows.Forms.Button btnSimetrica;
        private System.Windows.Forms.Button btnTransposta;
        private System.Windows.Forms.Button btnSoma;
        private System.Windows.Forms.Button btnSubtrair;
        private System.Windows.Forms.Button btnMultiplica;
    }
}

